package projects.third_topic.api.github;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class PatchUpdateRepoMethod extends AbstractApiMethodV2 {
    public PatchUpdateRepoMethod() {
        super("api.github/_patch_update_repo/rq.json", "api.github/_patch_update_repo/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        request.header("Authorization", "Bearer token");
    }
}
