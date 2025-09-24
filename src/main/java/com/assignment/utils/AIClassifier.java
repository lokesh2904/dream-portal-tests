package com.assignment.utils;

public class AIClassifier {
    public static String classifyDream(String dreamName) {
        String lower = dreamName.toLowerCase();
        if (lower.contains("monster") || lower.contains("chase") || lower.contains("maze")
                || lower.contains("falling") || lower.contains("lost") 
                || lower.contains("dark") || lower.contains("late")   // NEW keyword
                || lower.contains("exam")) {                          // NEW keyword
            return "Bad";
        }
        if (lower.contains("flying") || lower.contains("mountain") || lower.contains("beach")
                || lower.contains("happy") || lower.contains("friend") || lower.contains("family")) {
            return "Good";
        }
        return "Good";
    }
}
