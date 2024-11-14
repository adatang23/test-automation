package projects.third_topic.api.github;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class PostCreateRepoMethod extends AbstractApiMethodV2 {
    public PostCreateRepoMethod() {
        super("api.github/_post_create_repo/rq.json", "api.github/_post_create_repo/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        request.header("Authorization", "Bearer token");
    }
}
