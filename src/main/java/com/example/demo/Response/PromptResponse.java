package com.example.demo.Response;

import java.util.List;

public class PromptResponse {

    private List<Candidate> candidates;
    private UsageMetadata usageMetadata;
    private String modelVersion;

    // Getters and setters

    public static class Candidate {
        private Content content;
        private String finishReason;
        private double avgLogprobs;

        // Getters and setters

        public static class Content {
            private List<Part> parts;
            private String role;

            // Getters and setters

            public static class Part {
                private String text;

                // Constructor, getters, and setters
                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public List<Part> getParts() {
                return parts;
            }

            public void setParts(List<Part> parts) {
                this.parts = parts;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public Content getContent() {
            return content;
        }

        public void setContent(Content content) {
            this.content = content;
        }

        public String getFinishReason() {
            return finishReason;
        }

        public void setFinishReason(String finishReason) {
            this.finishReason = finishReason;
        }

        public double getAvgLogprobs() {
            return avgLogprobs;
        }

        public void setAvgLogprobs(double avgLogprobs) {
            this.avgLogprobs = avgLogprobs;
        }
    }

    public static class UsageMetadata {
        private int promptTokenCount;
        private int candidatesTokenCount;
        private int totalTokenCount;

        // Getters and setters

        public int getPromptTokenCount() {
            return promptTokenCount;
        }

        public void setPromptTokenCount(int promptTokenCount) {
            this.promptTokenCount = promptTokenCount;
        }

        public int getCandidatesTokenCount() {
            return candidatesTokenCount;
        }

        public void setCandidatesTokenCount(int candidatesTokenCount) {
            this.candidatesTokenCount = candidatesTokenCount;
        }

        public int getTotalTokenCount() {
            return totalTokenCount;
        }

        public void setTotalTokenCount(int totalTokenCount) {
            this.totalTokenCount = totalTokenCount;
        }
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public UsageMetadata getUsageMetadata() {
        return usageMetadata;
    }

    public void setUsageMetadata(UsageMetadata usageMetadata) {
        this.usageMetadata = usageMetadata;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }
}
