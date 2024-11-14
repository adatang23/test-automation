package projects.third_topic.api.github;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class PostCreateReactionForIssueMethod extends AbstractApiMethodV2 {
    public PostCreateReactionForIssueMethod() {
        super("api.github/post_reaction_issue/rq.json",
                "api.github/post_reaction_issue/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        request.header("Authorization", "Bearer token");
    }
}
