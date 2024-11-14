package projects.third_topic.api.github;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class DeleteRepoMethod extends AbstractApiMethodV2 {
    public DeleteRepoMethod() {
        super(null, "api.github/delete_repo/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        request.header("Authorization", "Bearer token");
    }
}
