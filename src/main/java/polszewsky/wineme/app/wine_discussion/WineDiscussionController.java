package polszewsky.wineme.app.wine_discussion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import polszewsky.wineme.app.wine_discussion.requests.WineDiscussionRequest;

@RestController
@RequestMapping("/wine/discussion")
public class WineDiscussionController {

    @Autowired
    private WineDiscussionService wineDiscussionService;

    @PutMapping
    public ResponseEntity<WineDiscussion> createWineDiscussion(@RequestBody @Validated WineDiscussionRequest discussionRequest){

        WineDiscussion discussion = wineDiscussionService.createEntry(discussionRequest);
        return new ResponseEntity<>(discussion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WineDiscussion> updateWineDiscussion(@RequestBody @Validated WineDiscussionRequest discussionRequest){

        WineDiscussion discussion = wineDiscussionService.updateEntry(discussionRequest);
        return new ResponseEntity<>(discussion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteWineDiscussion(@PathVariable Integer id){

        boolean deleted = wineDiscussionService.deleteEntry(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
