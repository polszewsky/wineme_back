package polszewsky.wineme.app.wine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import polszewsky.wineme.app.wine.requests.WineFilterObject;

@RestController
@RequestMapping("/wine")
public class WineController {

    @Autowired
    private WineService wineService;

    @GetMapping
    @PreAuthorize("@SecurityMethods.hasRight('READ_WINES')")
    public ResponseEntity<Page<Wine>> getWineList() {

        Page<Wine> wines = wineService.findAll();
        return new ResponseEntity<>(wines, HttpStatus.OK);
    }

    @PostMapping("/filtered")
    @PreAuthorize("@SecurityMethods.hasRight('READ_WINES')")
    public ResponseEntity<Page<Wine>> getWineListFiltered(@RequestBody WineFilterObject filterObject) {

        Page<Wine> wines = wineService.findAllByFilters(filterObject);
        return new ResponseEntity<>(wines, HttpStatus.OK);
    }

    @GetMapping("/{wineId}")
    @PreAuthorize("@SecurityMethods.hasRight('READ_WINES')")
    public ResponseEntity<Wine> getWineDetails(@PathVariable Integer wineId) {

        Wine wine = wineService.findById(wineId);
        return new ResponseEntity<>(wine, HttpStatus.OK);
    }
}
