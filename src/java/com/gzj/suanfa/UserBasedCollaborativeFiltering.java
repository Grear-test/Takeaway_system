package com.gzj.suanfa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserBasedCollaborativeFiltering {
    private Map<String, Map<String, Integer>> userRatings;

    public UserBasedCollaborativeFiltering() {
        userRatings = new HashMap<>();
    }

    public void addUserRating(String user, String item, int rating) {
        if (!userRatings.containsKey(user)) {
            userRatings.put(user, new HashMap<>());
        }
        userRatings.get(user).put(item, rating);
    }

    public double calculateSimilarity(Map<String, Integer> ratings1, Map<String, Integer> ratings2) {
        Set<String> commonItems = ratings1.keySet();
        commonItems.retainAll(ratings2.keySet());
        if (commonItems.size() == 0) {
            return 0.0;
        }
        double sumOfSquares = 0.0;
        for (String item : commonItems) {
            int rating1 = ratings1.get(item);
            int rating2 = ratings2.get(item);
            sumOfSquares += Math.pow(rating1 - rating2, 2);
        }
        return 1 / (1 + Math.sqrt(sumOfSquares));
    }

    public double predictRating(String user, String item) {
        if (!userRatings.containsKey(user)) {
            return 0.0;
        }
        Map<String, Integer> currentUserRatings = userRatings.get(user);
        double weightedSum = 0.0;
        double similaritySum = 0.0;
        for (String otherUser : userRatings.keySet()) {
            if (otherUser.equals(user)) {
                continue;
            }
            Map<String, Integer> otherUserRatings = userRatings.get(otherUser);
            if (otherUserRatings.containsKey(item)) {
                double similarity = calculateSimilarity(currentUserRatings, otherUserRatings);
                int rating = otherUserRatings.get(item);
                weightedSum += similarity * rating;
                similaritySum += similarity;
            }
        }
        if (similaritySum == 0.0) {
            return 0.0;
        }
        return weightedSum / similaritySum;
    }

    public static void main(String[] args) {
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering();

        // 添加用户评分数据
        filter.addUserRating("User1", "Item1", 5);
        filter.addUserRating("User1", "Item2", 3);
        filter.addUserRating("User2", "Item1", 4);
        filter.addUserRating("User2", "Item2", 5);

        // 预测用户对某项物品的评分
        String targetUser = "User1";
        String targetItem = "Item3";
        double predictedRating = filter.predictRating(targetUser, targetItem);

        // 输出预测结果
        System.out.println("预测用户 " + targetUser + " 对物品 " + targetItem + " 的评分为: " + predictedRating);
    }
}
