package am.itspace.onlinechesstournamentmvc.controller;

import am.itspace.onlinechesstournamentcommon.service.WorldChessChampionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WorldChessChampionController {

    private final WorldChessChampionService worldChessChampionService;

    @GetMapping
    public String getAll(@PageableDefault(sort = "worldChessChampionNumber", direction = Sort.Direction.ASC) Pageable pageable){
        worldChessChampionService.findAll(pageable);
        return "";
    }
}
