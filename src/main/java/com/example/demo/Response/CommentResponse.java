package com.example.demo.Response;

import java.util.List;

public class CommentResponse {

    private String kind;
    private String etag;
    private PageInfo pageInfo;
    private List<Item> items;

    // Getters and Setters
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // Nested PageInfo Class
    public static class PageInfo {
        private int totalResults;
        private int resultsPerPage;

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public int getResultsPerPage() {
            return resultsPerPage;
        }

        public void setResultsPerPage(int resultsPerPage) {
            this.resultsPerPage = resultsPerPage;
        }
    }

    // Nested Item Class
    public static class Item {
        private String kind;
        private String etag;
        private String id;
        private Snippet snippet;

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getEtag() {
            return etag;
        }

        public void setEtag(String etag) {
            this.etag = etag;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Snippet getSnippet() {
            return snippet;
        }

        public void setSnippet(Snippet snippet) {
            this.snippet = snippet;
        }

        // Nested Snippet Class
        public static class Snippet {
            private String channelId;
            private String videoId;
            private TopLevelComment topLevelComment;
            private boolean canReply;
            private int totalReplyCount;
            private boolean isPublic;

            public String getChannelId() {
                return channelId;
            }

            public void setChannelId(String channelId) {
                this.channelId = channelId;
            }

            public String getVideoId() {
                return videoId;
            }

            public void setVideoId(String videoId) {
                this.videoId = videoId;
            }

            public TopLevelComment getTopLevelComment() {
                return topLevelComment;
            }

            public void setTopLevelComment(TopLevelComment topLevelComment) {
                this.topLevelComment = topLevelComment;
            }

            public boolean isCanReply() {
                return canReply;
            }

            public void setCanReply(boolean canReply) {
                this.canReply = canReply;
            }

            public int getTotalReplyCount() {
                return totalReplyCount;
            }

            public void setTotalReplyCount(int totalReplyCount) {
                this.totalReplyCount = totalReplyCount;
            }

            public boolean isPublic() {
                return isPublic;
            }

            public void setPublic(boolean isPublic) {
                this.isPublic = isPublic;
            }

            // Nested TopLevelComment Class
            public static class TopLevelComment {
                private String kind;
                private String etag;
                private String id;
                private CommentSnippet snippet;

                public String getKind() {
                    return kind;
                }

                public void setKind(String kind) {
                    this.kind = kind;
                }

                public String getEtag() {
                    return etag;
                }

                public void setEtag(String etag) {
                    this.etag = etag;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public CommentSnippet getSnippet() {
                    return snippet;
                }

                public void setSnippet(CommentSnippet snippet) {
                    this.snippet = snippet;
                }

                // Nested CommentSnippet Class
                public static class CommentSnippet {
                    private String channelId;
                    private String videoId;
                    private String textDisplay;
                    private String textOriginal;
                    private String authorDisplayName;
                    private String authorProfileImageUrl;
                    private String authorChannelUrl;
                    private AuthorChannelId authorChannelId;
                    private boolean canRate;
                    private String viewerRating;
                    private int likeCount;
                    private String publishedAt;
                    private String updatedAt;

                    public String getChannelId() {
                        return channelId;
                    }

                    public void setChannelId(String channelId) {
                        this.channelId = channelId;
                    }

                    public String getVideoId() {
                        return videoId;
                    }

                    public void setVideoId(String videoId) {
                        this.videoId = videoId;
                    }

                    public String getTextDisplay() {
                        return textDisplay;
                    }

                    public void setTextDisplay(String textDisplay) {
                        this.textDisplay = textDisplay;
                    }

                    public String getTextOriginal() {
                        return textOriginal;
                    }

                    public void setTextOriginal(String textOriginal) {
                        this.textOriginal = textOriginal;
                    }

                    public String getAuthorDisplayName() {
                        return authorDisplayName;
                    }

                    public void setAuthorDisplayName(String authorDisplayName) {
                        this.authorDisplayName = authorDisplayName;
                    }

                    public String getAuthorProfileImageUrl() {
                        return authorProfileImageUrl;
                    }

                    public void setAuthorProfileImageUrl(String authorProfileImageUrl) {
                        this.authorProfileImageUrl = authorProfileImageUrl;
                    }

                    public String getAuthorChannelUrl() {
                        return authorChannelUrl;
                    }

                    public void setAuthorChannelUrl(String authorChannelUrl) {
                        this.authorChannelUrl = authorChannelUrl;
                    }

                    public AuthorChannelId getAuthorChannelId() {
                        return authorChannelId;
                    }

                    public void setAuthorChannelId(AuthorChannelId authorChannelId) {
                        this.authorChannelId = authorChannelId;
                    }

                    public boolean isCanRate() {
                        return canRate;
                    }

                    public void setCanRate(boolean canRate) {
                        this.canRate = canRate;
                    }

                    public String getViewerRating() {
                        return viewerRating;
                    }

                    public void setViewerRating(String viewerRating) {
                        this.viewerRating = viewerRating;
                    }

                    public int getLikeCount() {
                        return likeCount;
                    }

                    public void setLikeCount(int likeCount) {
                        this.likeCount = likeCount;
                    }

                    public String getPublishedAt() {
                        return publishedAt;
                    }

                    public void setPublishedAt(String publishedAt) {
                        this.publishedAt = publishedAt;
                    }

                    public String getUpdatedAt() {
                        return updatedAt;
                    }

                    public void setUpdatedAt(String updatedAt) {
                        this.updatedAt = updatedAt;
                    }

                    // Nested AuthorChannelId Class
                    public static class AuthorChannelId {
                        private String value;

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }
                }
            }
        }
    }
}

