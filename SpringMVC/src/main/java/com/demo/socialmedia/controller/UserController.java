package com.demo.socialmedia.controller;

import com.demo.socialmedia.model.Post;
import com.demo.socialmedia.model.User;
import com.demo.socialmedia.service.FollowService;
import com.demo.socialmedia.service.PostService;
import com.demo.socialmedia.service.UserService;
import com.demo.socialmedia.util.SessionAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private FollowService followService;

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        Integer userId = SessionAuth.getCurrentUserId(session);
        if (userId == null) {
            return "redirect:/login";
        }

        User user = userService.getUserById(userId);
        if (user == null) {
            SessionAuth.signOut(session);
            return "redirect:/login";
        }

        List<Post> posts = postService.getPostsByUserId(userId);
        model.addAttribute("user", user);
        model.addAttribute("posts", posts);
        model.addAttribute("followingUsers", followService.getFollowing(userId));
        model.addAttribute("followerUsers", followService.getFollowers(userId));
        return "profile";
    }
}
