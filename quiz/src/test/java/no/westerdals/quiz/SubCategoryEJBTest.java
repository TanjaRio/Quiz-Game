package no.westerdals.quiz;

import no.westerdals.quiz.ejb.QuizEJB;
import no.westerdals.quiz.ejb.SubCategoryEJB;
import no.westerdals.quiz.ejb.SubSubCategoryEJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Created by tanja on 10/26/2016.
 */
@RunWith(Arquillian.class)
public class SubCategoryEJBTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "no.westerdals.quiz.ejb")
                .addPackages(true, "no.westerdals.quiz.entity")
                .addAsResource("META-INF/persistence.xml");
    }

    @Inject
    private QuizEJB quizEJB;

    @Inject
    private SubCategoryEJB subCategoryEJB;

    @Before
    @After
    public void cleanDatabase() {
        subCategoryEJB.getAll().stream().forEach(c -> subCategoryEJB.deleteSubCategory(c.getSubCategoryName()));
        assertEquals(0, quizEJB.getAll().size());
    }

    @Test
    public void testCleanDB() {
        int n = subCategoryEJB.getAll().size();
        assertEquals(0, n);
    }
}
