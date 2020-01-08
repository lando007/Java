public class TradeQueue{

    //headnode and trade nodes
    TradeNode headTradeNode;
    TradeNode tailTradeNode;
    //enque adding
    public void enqueue(String sStockSymbol, int iPurchaseShareCount, boolean bBuy){
        TradeNode trade = new TradeNode();
        trade.sStockSymbol = sStockSymbol;
        trade.bBuy = bBuy;
        trade.iShareCount = iPurchaseShareCount;

        if (headTradeNode == null){
            headTradeNode = trade;
            tailTradeNode = trade;
        }else{
            tailTradeNode.nextTradeNode = trade;
            tailTradeNode = trade;
        }

    }
    //deque subtracting
    public TradeNode dequeue(){
        if (headTradeNode != null){
            TradeNode oldHead = headTradeNode;
            headTradeNode.nextTradeNode = headTradeNode;
            return oldHead;
        }
        return null;
    }
}
