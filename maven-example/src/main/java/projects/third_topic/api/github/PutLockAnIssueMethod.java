package projects.third_topic.api.github;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class PutLockAnIssueMethod extends AbstractApiMethodV2 {
    public PutLockAnIssueMethod() {
        super("api.github/_put_lock_issue/rq.json", "api.github/_put_lock_issue/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        request.header("Authorization", "Bearer token");
    }
}
