import java.text.DecimalFormat;

public class TradingAccount extends Account{


    float bBalance;

    StockPositions[] sStockPositions;
    public int getHoldingsIndexBySymbol(String sSymbol){
        for (int i = 0; i < sStockPositions.length; i++){
            if (sStockPositions[i].sStockSymbol.equals(sSymbol)) return i;
        }
        return -1;
    }

    public String toString(){
        String iBalancesheet =  " | Balance: $" +
                new DecimalFormat("#,###.##").format(bBalance) +
                " <> ShareAmount: ";

        for (StockPositions stock : sStockPositions){
            iBalancesheet += stock.sStockSymbol +
                    ":__ " + stock.iShareCount + " ";
        }
        return iBalancesheet;
    }
}
