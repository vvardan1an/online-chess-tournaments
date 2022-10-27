package am.itspace.onlinechesstournaments.controller;

import am.itspace.onlinechesstournaments.service.WorldChessChampionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class WorldChessChampionController {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

    private final WorldChessChampionService wccService;

    @GetMapping("/worldChessChampions")
    public String worldChessChampionsPage(ModelMap modelMap) {
        modelMap.addAttribute("currentYear", simpleDateFormat.format(new Date()));
        modelMap.addAttribute("wccList", wccService.findAll());
        return "worldChessChampions";
    }

    @GetMapping(value = "/worldChampionPicture/get", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getPicture(@RequestParam("pngName") String pngName) throws IOException {
        return wccService.getPicture(pngName);
    }
}
