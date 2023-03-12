package com.gcp.springboot.jamsession.api.post;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@Controller
public class PostController {

@Autowired
    private PostService postService;

    @PostMapping(value = "/posts/")
    @ResponseBody
    public ResponseEntity<Post> addPost(@RequestParam(required = true, value="title") String title,
            @RequestParam(required = true, value="description") String description,
            @RequestParam(required = true, value="datetime") String datetime,
            @RequestParam(required = true, value="file") MultipartFile file,
            @RequestParam(required = true, value="user_id") Long userId) {

        try {
            Post post = postService.createPost(title, description, datetime, file, userId);
            return new ResponseEntity<>(post, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/posts/{post_id}/media/")
    public ResponseEntity<byte[]> getPost(@PathVariable("post_id") Long postId) {
        Optional<Post> post = postService.getPost(postId);

        if(post.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + post.get().getPostId() + ".mp3\"")
            .body(post.get().getData());
    }
}
