package com.team10.whatis.post.dto;

import com.team10.whatis.post.entity.Category;
import com.team10.whatis.post.entity.Post;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PostResponseDto {
    private Long id;
    private Category category;
    private String title;
    private String thumbnail;
    private String projectImage;
    private int targetAmount;
    private int totalAmount;
    private int price;
    private LocalDate deadLine;
    private int percentage;
    private String name;
    private String summary;
    private String storyBoard;
    private List<String> tags = new ArrayList<>();
    private int likeCount;
    private boolean likeStatus;


    public PostResponseDto(Post post, boolean likeStatus) {
        this.id = post.getId();
        this.category = post.getCategory();
        this.title = post.getTitle();
        this.thumbnail = post.getThumbnail();
        this.projectImage = post.getProjectImage();
        this.targetAmount = post.getTargetAmount();
        this.totalAmount = post.getTotalAmount();
        this.deadLine = post.getDeadLine();
        this.percentage = calcPercentage(post.getTotalAmount(), post.getTargetAmount());
        this.price = post.getPrice();
        this.name = post.getMember().getUsername();
        this.summary = post.getSummary();
        this.storyBoard = post.getStoryBoard();
        post.getTags().forEach(tag -> this.tags.add(tag.getTag().getName()));
        this.likeCount = post.getLikeCount();
        this.likeStatus = likeStatus;
    }

    private int calcPercentage(int totalAmount, int targetAmount) {
        return (int) Math.round(((double) totalAmount / targetAmount * 100));
    }

    public void setLikeStatus(boolean likeStatus) {
        this.likeStatus = likeStatus;
    }
}
