import java.security.SecureRandom;

public class StockEngine {

    SecureRandom oRand;
    Stock[] stocks;

     int iTrendChance = 80;
     int iMaxStockPrice = 2500;

    public StockEngine() {
        oRand = new SecureRandom();

        Stock APPL = new Stock();
        APPL.sStockSymbol = "APPL";

        APPL.iPricePerShare = oRand.nextInt(iMaxStockPrice) + 1;

        APPL.bLastMoveUp = oRand.nextBoolean();

        Stock FB = new Stock();
        FB.sStockSymbol = "FB";

        FB.iPricePerShare = oRand.nextInt(iMaxStockPrice) + 1;

        FB.bLastMoveUp = oRand.nextBoolean();

        Stock AMZN = new Stock();
        AMZN.sStockSymbol = "AMZN ";

        AMZN.iPricePerShare = oRand.nextInt(iMaxStockPrice) + 1;

        AMZN.bLastMoveUp = oRand.nextBoolean();

        stocks = new Stock[]{APPL, FB, AMZN};
    }

    public void cycleTheTurn() {
        for (int i = 0; i < stocks.length; i++) {
            if
                    (oRand.nextInt(100) < iTrendChance) {

            } else {

            }
        }
    }
}