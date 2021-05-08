import hu.elte.madtycoon.core.Resources;
import hu.elte.madtycoon.core.World;
import hu.elte.madtycoon.render.AnimationResource;
import hu.elte.madtycoon.utils.Loan;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoanTest {

    public World world;

    @Before
    public void createWorld() {
        try {
            Resources.Instance.load();
            AnimationResource.Instance.load();
        } catch (Exception exception) {

        }
        world = new World();
    }

    @Test
    public void create() {
        Loan loan = new Loan(8,20000,.2F);

        assertEquals(loan.isRentable(), Boolean.TRUE);
        assertEquals(loan.amount,20000);
    }

    @Test
    public void rentLoan() {
        Loan loan = new Loan(8,20000,.2F);

        loan.rent(world);

        assertEquals(loan.isRentable(), Boolean.FALSE);
    }

    @Test (expected = Exception.class)
    public void rentNonRentableLoan() {
        Loan loan = new Loan(8,20000,.2F);

        loan.rent(world);
        loan.rent(world);
    }

    @Test
    public void payLoan() {
        Loan loan = new Loan(8,20000,.2F);

        loan.rent(world);
        loan.repay(world);

        assertEquals(loan.getRemaining(), 7);
    }

    @Test
    public void calculatingPiece() {
        Loan loan = new Loan(8,20000,.2F);

        int piece = loan.getPiece();

        assertEquals(piece, 3000);
    }

}
