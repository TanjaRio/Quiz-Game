import ejb.SubSubCategoryEJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.inject.Inject;

/**
 * Created by tanja on 10/26/2016.
 */
@RunWith(Arquillian.class)
public class SubSubCategoryEJBTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "no.westerdals")
                .addAsResource("META-INF/persistence.xml");
    }

    @Inject
    private SubSubCategoryEJB subSubCategoryEJB;

    @Before
    @After
    public void cleanDatabase() {
        subSubCategoryEJB.getAll.stream().forEach(n -> ejb.deleteNews(n.getId()));
        assertEquals(0, ejb.getAll().size());
    }
}
