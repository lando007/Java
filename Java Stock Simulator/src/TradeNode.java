public class TradeNode{

    int iShareCount;
    String sStockSymbol;
    boolean bBuy;
    TradeNode nextTradeNode;


    public String toString(){

        return sStockSymbol + ": " +

                iShareCount +

                " -_- " + bBuy
                + " || " +
                nextTradeNode;
    }
}
