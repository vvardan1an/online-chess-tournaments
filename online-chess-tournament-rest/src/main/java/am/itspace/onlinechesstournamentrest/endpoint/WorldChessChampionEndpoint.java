package am.itspace.onlinechesstournamentrest.endpoint;

import am.itspace.onlinechesstournamentcommon.mapper.WorldChessChampionMapper;
import am.itspace.onlinechesstournamentcommon.service.WorldChessChampionService;
import am.itspace.onlinechesstournamentdatatransfer.request.UpdateWccRequest;
import am.itspace.onlinechesstournamentdatatransfer.request.WccRequest;
import am.itspace.onlinechesstournamentdatatransfer.response.WccResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

    @GetMapping
    public ResponseEntity<List<WccResponse>> getAll(@PageableDefault(sort = "worldChampionNumber",
            direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(wccMapper.toResponseList(wccService.findAll(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WccResponse> getById(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(wccMapper.toResponse(wccService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid WccRequest wccRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()) {
                stringBuilder.append(error.getDefaultMessage()).append("\n");
            }
            return ResponseEntity.badRequest().body(stringBuilder);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(wccService.save(wccMapper.toEntity(wccRequest)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody @Valid UpdateWccRequest updateWccRequest) {
        return ResponseEntity.ok().body(wccMapper.toResponse(wccService.update(updateWccRequest, id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        return ResponseEntity.ok(wccService.delete(id));
    }
}
