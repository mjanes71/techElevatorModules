package com.techelevator.example.controller;

import com.techelevator.example.model.Vote;
import com.techelevator.example.model.VoteDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@PreAuthorize("isAuthenticated()")
public class VoteController {

@PostMapping ("/vote")
    public Vote castVote(@Valid @RequestBody VoteDTO voteDTO, Principal principal ){
    Vote newVote = new Vote();
    newVote.setYesOrNo(voteDTO.getYesOrNo());
    newVote.setVoterId(principal.getName());
    return newVote;
}
}
