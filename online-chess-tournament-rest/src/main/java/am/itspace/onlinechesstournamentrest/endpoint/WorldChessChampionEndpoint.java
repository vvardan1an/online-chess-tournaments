package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.mapper.WorldChessChampionMapper;
import am.itspace.onlinechesstournamentcommon.service.WorldChessChampionService;
import am.itspace.onlinechesstournamentcommon.util.BindingResultUtil;
import am.itspace.onlinechesstournamentdatatransfer.request.UpdateWccRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.WccRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.WccResponse;
import am.itspace.onlinechesstournamentrest.facade.AdminAccessOnly;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequestMapping("/worldChessChampions")
@RequiredArgsConstructor
@RestController
public class WorldChessChampionEndpoint {

    private final WorldChessChampionService wccService;

    private final WorldChessChampionMapper wccMapper;

    private final AdminAccessOnly adminAccessOnly;

    @GetMapping
    public ResponseEntity<List<WccResponse>> getAll(@PageableDefault(sort = "worldChampionNumber",
            direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(wccMapper.toResponseList(wccService.findAll(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WccResponse> getById(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(wccMapper.toResponse(wccService.getById(id)));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid WccRequest wccRequest,
                                    BindingResult bindingResult) {
        return adminAccessOnly.createWorldChessChampion(wccRequest, bindingResult);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,
                                    @RequestBody @Valid UpdateWccRequest updateWccRequest,
                                    BindingResult bindingResult) {
        return adminAccessOnly.updateWorldChessChampion(id, updateWccRequest, bindingResult);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        return adminAccessOnly.deleteWorldChessChampion(id);
    }
}
