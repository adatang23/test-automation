package projects.third_topic.api.github;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class PostIssueCreateMethod extends AbstractApiMethodV2 {
    public PostIssueCreateMethod() {
        super("api.github/post_create_issue/rq.json", "api.github/post_create_issue/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        request.header("Authorization", "Bearer token");
    }
}



