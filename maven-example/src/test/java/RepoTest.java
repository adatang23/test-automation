import java.lang.invoke.MethodHandles;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import projects.third_topic.api.github.*;



public class RepoTest extends AbstractTest {

    private static final Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Test(priority = 1, description = "JIRA#DEMO-1")
    @MethodOwner(owner="stang")
    public void createRepoTest() {
        PostCreateRepoMethod apiRepo = new PostCreateRepoMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        apiRepo.callAPI();
        apiRepo.validateResponse();
        apiRepo.validateResponseAgainstSchema("api.github/_post_create_repo/rs.schema");
    }

    @Test(priority = 2, description = "JIRA#DEMO-2")
    @MethodOwner(owner="stang")
    public void getRepoTest() {
        GetRepoMethod apiRepo = new GetRepoMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiRepo.callAPI();
        apiRepo.validateResponse();
        apiRepo.validateResponseAgainstSchema("api.github/get_repo/rs.schema");
    }

    @Test(priority = 3, description = "JIRA#DEMO-3")
    @MethodOwner(owner="stang")
    public void postIssueCreateTest() {
        PostIssueCreateMethod apiRepo = new PostIssueCreateMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        apiRepo.callAPI();
        apiRepo.validateResponse();
        apiRepo.validateResponseAgainstSchema("api.github/post_create_issue/rs.schema");
    }

    @Test(priority = 4, description = "JIRA#DEMO-4")
    @MethodOwner(owner="stang")
    public void getIssueTest() {
        GetIssueMethod apiRepo = new GetIssueMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiRepo.callAPI();
        apiRepo.validateResponse();
        apiRepo.validateResponseAgainstSchema("api.github/get_issue/rs.schema");
    }

    @Test(priority = 5, description = "JIRA#DEMO-5")
    @MethodOwner(owner="stang")
    public void patchIssueUpdateTest() {
        PatchIssueUpdateMethod apiRepo = new PatchIssueUpdateMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiRepo.callAPI();
        apiRepo.validateResponse();
    }

    @Test(priority = 6, description = "JIRA#DEMO-6")
    @MethodOwner(owner="stang")
    public void postCreateCommentIssueTest() {
        PostCreateCommentIssueMethod apiRepo = new PostCreateCommentIssueMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        apiRepo.callAPI();
        apiRepo.validateResponse();
    }

    @Test(priority = 7, description = "JIRA#DEMO-7")
    @MethodOwner(owner="stang")
    public void postCreateReactionForIssueTest() {
        PostCreateReactionForIssueMethod apiRepo = new PostCreateReactionForIssueMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        apiRepo.callAPI();
        apiRepo.validateResponse();
        apiRepo.validateResponseAgainstSchema("api.github/post_reaction_issue/rs.schema");
    }

    @Test(priority = 8, description = "JIRA#DEMO-8")
    @MethodOwner(owner="stang")
    public void putLockAnIssueTest() {
        PutLockAnIssueMethod apiRepo = new PutLockAnIssueMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        apiRepo.callAPI();
    }

    @Test(priority = 9, description = "JIRA#DEMO-9")
    @MethodOwner(owner="stang")
    public void patchUpdateReoTest() {
        PatchUpdateRepoMethod apiRepo = new PatchUpdateRepoMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.OK_200);
        apiRepo.callAPI();
        apiRepo.validateResponse();
        apiRepo.validateResponseAgainstSchema("api.github/_patch_update_repo/rs.schema");
    }

    @Test(priority = 10, description = "JIRA#DEMO-10")
    @MethodOwner(owner="stang")
    public void deleteRepoTest() {
        DeleteRepoMethod apiRepo = new DeleteRepoMethod();
        apiRepo.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        apiRepo.callAPI();
    }
}
