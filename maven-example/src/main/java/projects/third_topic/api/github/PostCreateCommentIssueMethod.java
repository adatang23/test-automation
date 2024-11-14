package projects.third_topic.api.github;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class PostCreateCommentIssueMethod extends AbstractApiMethodV2 {
    public PostCreateCommentIssueMethod() {
        super("api.github/post_create_comment_to_issue/rq.json",
                "api.github/post_create_comment_to_issue/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        request.header("Authorization", "Bearer token");
    }
}
