package com.gcp.springboot.jamsession.api.post;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gcp.springboot.jamsession.api.user.User;
import com.gcp.springboot.jamsession.api.user.UserRepository;

import java.io.IOException;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post createPost(String title, String description, String datetime, MultipartFile file, Long userId) 
            throws IOException {
        
        Optional<User> user = userRepository.findById(userId);
        
        if(user.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Post post = postRepository.save(new Post(title, description, datetime, file.getBytes(), file.getContentType(), user.get()));
        String link = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/posts/")
            .path(Long.toString(post.getPostId()))
            .path("/media/")
            .toUriString();
        post.setMediaLink(link);

        postRepository.save(post);
        return post;
    }

    public Optional<Post> getPost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post;
    }
}
