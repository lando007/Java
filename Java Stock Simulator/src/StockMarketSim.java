import javax.swing.*;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Arrays;

public class StockMarketSim{

    StockEngine oStockEngine;
     float startingBalance = 100000000.00F;
    TradeQueue oTradeQueue;

    TradingAccount oTradingAccount;



    public void start(){
        oStockEngine = new StockEngine();

        oTradingAccount = new TradingAccount();
        oTradingAccount.bBalance = startingBalance;
        oTradingAccount.sStockPositions = new StockPositions[oStockEngine.stocks.length];
        for (int i = 0; i < oTradingAccount.sStockPositions.length; i++){
            StockPositions stockShares = new StockPositions();
            stockShares.sStockSymbol = oStockEngine.stocks[i].sStockSymbol;
            oTradingAccount.sStockPositions[i] = stockShares;
        }

        oTradeQueue = new TradeQueue();

        runUI();
    }

    private void runUI(){
        Scanner iInput = new Scanner(System.in);
        String sScanner = null;
        boolean bCorrectLog = false;
        while (!bCorrectLog){
            while ((sScanner = JOptionPane.showInputDialog(null,
                    "Please enter your username", null, JOptionPane.INFORMATION_MESSAGE )) != null
                    && !sScanner.equalsIgnoreCase("exit") && !isValidUsername(sScanner));
            if (sScanner == null || sScanner.equalsIgnoreCase("exit")) break;

            String sUser = sScanner;

            JPasswordField passField = new JPasswordField();
            if (JOptionPane.showConfirmDialog(null, passField, "Enter your password",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE ) != JOptionPane.OK_OPTION) break;
            bCorrectLog = (sUser.equals(oTradingAccount.getUsername()) && passField.getPassword() != null
                    && passField.getPassword().length > 0
                    && !String.valueOf(passField.getPassword()).equalsIgnoreCase("exit")
                    && oTradingAccount.isValidLogin(String.valueOf(passField.getPassword())));
            if (!bCorrectLog && JOptionPane.showConfirmDialog(null, "your password or user name is wrong!",
                    null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE ,
                    null) != JOptionPane.OK_OPTION) break;
        }

        if (bCorrectLog){
            System.out.println("Welcome to stocks and good luck " + oTradingAccount.getUsername() + "!");

            Stock stock = null;
            boolean isBuy;
            while(oTradingAccount.bBalance > 0){
                System.out.println(oTradingAccount);
                for (Stock stk : oStockEngine.stocks){
                    System.out.println(stk);
                }

                String[] stockOptions = getStockOptions();
                if (stockOptions != null){
                    System.out.println(Arrays.asList(stockOptions).toString());
                    System.out.println("Which stock would you like to trade?: ");
                    while (!(sScanner = iInput.nextLine()).equalsIgnoreCase("exit") &&
                            (stock = getStock(stockOptions, sScanner)) == null);

                    if (sScanner.equalsIgnoreCase("exit")) break;
                    else if (sScanner.trim().isEmpty() ||
                            sScanner.equalsIgnoreCase("skip")) continue;
                    String[] tradeOptions = getTradeOptions(stock);
                    String tradeMsg = "";
                    for (int i = 0; i < tradeOptions.length; i++){
                        tradeMsg += tradeOptions[i] + ((i < tradeOptions.length-1) ? " or " : "?: ");
                    }
                    System.out.println(tradeMsg.substring(0, 1).toUpperCase() + tradeMsg.substring(1));

                    while (!(sScanner = iInput.nextLine()).equalsIgnoreCase
                            ("exit") &&
                            !isTradeOption(tradeOptions, sScanner));
                    if (sScanner.equalsIgnoreCase("exit")) break;

                    else if (sScanner.trim().isEmpty() || sScanner.equalsIgnoreCase("skip")) continue;

                    isBuy = (sScanner.equalsIgnoreCase("b") ||
                            sScanner.equalsIgnoreCase("buy"));

                    System.out.println("How many shares would you lie to buy?: ");

                    while (!(sScanner = iInput.nextLine()).equalsIgnoreCase("exit")
                            && !isTrade(stock, isBuy, sScanner));

                    if (sScanner.equalsIgnoreCase("exit")) break;

                    else if (sScanner.trim().isEmpty() ||
                            sScanner.equalsIgnoreCase("skip")) continue;

                    oTradeQueue.enqueue(stock.sStockSymbol,
                            Integer.parseInt(sScanner), isBuy);



                    oStockEngine.cycleTheTurn();

                    processTrades();


                }else{
                    System.out.println("sorry ,maybe the storck marektet isnt for you!");
                    if ((sScanner = iInput.nextLine()).trim().isEmpty()) continue;

                    else break;
                }

            }
            iInput.close();

            System.out.println("The stock market has closed!");

            if (oTradingAccount.bBalance == startingBalance)

                System.out.println("You are exactly where you started!");
            else System.out.println("Your balance went__ " +
                    ((oTradingAccount.bBalance > startingBalance) ? "up" : "down") + " $" +
                    new DecimalFormat("#,###.##").format(Math.abs(oTradingAccount.bBalance-startingBalance))
                    + " from your starting balance!");
            System.out.println(oTradingAccount);
        }
    }


    private String[] getTradeOptions(Stock stock){
        String[] options = new String[2];
        int index = 0;if (oTradingAccount.bBalance/stock.iPricePerShare >= 1.0F) options[index++] = "buy";
        if (oTradingAccount.sStockPositions[oTradingAccount.getHoldingsIndexBySymbol
                (stock.sStockSymbol)].iShareCount > 0) options[index++] = "sell";
        if (index > 1) return options;
        else return new String[]{options[0]};
    }

    private String[] getStockOptions(){
        String[] stocks = new String[oStockEngine.stocks.length];

        int index = 0;


        for (int i = 0; i < oStockEngine.stocks.length; i++){
            if ((oTradingAccount.bBalance/oStockEngine.stocks[i].iPricePerShare) >= 1.0F)
                stocks[index++] = oStockEngine.stocks[i].sStockSymbol;
        }


        for (int i = 0; index < (stocks.length-1) && i < oTradingAccount.sStockPositions.length; i++){

            if (oTradingAccount.sStockPositions[i].iShareCount > 0) stocks[index++] =

                    oTradingAccount.sStockPositions[i].sStockSymbol;
        }
        if (index == 0) return null;
        else{
            String[] tempStocks = new String[index];

            for (int i = 0; i < tempStocks.length; i++){
                tempStocks[i] = stocks[i];
            }
            return tempStocks;
        }
    }

    private Stock getStock(String[] stockOptions, String symbol){

        if (symbol.trim().isEmpty() || symbol.equalsIgnoreCase("skip"))
            return new Stock();

        for (int i = 0; i < stockOptions.length; i++){
            if (stockOptions[i].equalsIgnoreCase(symbol)){ for (Stock stock : oStockEngine.stocks){
                if (stock.sStockSymbol.equals(stockOptions[i])) return stock; } }
        }return null;
    }



    private boolean isValidUsername(String sString){
        return sString.matches("^[a-zA-Z0-9]*$");
    }


    private boolean isInteger(String s){
        try{
            int i = Integer.parseInt(s);
            return !s.startsWith("-") && i > 0;
        }catch (Exception e){}
        return false;
    }

    private boolean isTrade(Stock stock, boolean isBuy, String shares){
        if (shares.trim().isEmpty() || shares.equalsIgnoreCase("skip")) return true;

        if (isInteger(shares)){
            int iNumShares = Integer.parseInt(shares);
            if (iNumShares > 0){ return ((isBuy) ? (iNumShares <= (int) (
                    oTradingAccount.bBalance/stock.iPricePerShare)) :
                    (iNumShares <=
                            oTradingAccount.sStockPositions
                                    [oTradingAccount.getHoldingsIndexBySymbol
                                    (stock.sStockSymbol)].iShareCount));
            }
        }
        return false;
    }
    private void processTrades(){
        TradeNode trade = null;

        while ((trade = oTradeQueue.dequeue()) != null){


        }
        System.out.println("[the headhead]: " + oTradeQueue.headTradeNode);
        System.out.println("[the tail]: " + oTradeQueue.tailTradeNode);


    }
    private boolean isTradeOption(String[] tradeOptions, String option){
        if (option.trim().isEmpty() || option.equalsIgnoreCase("skip")) return true;

        if (tradeOptions.length > 1){
            return (option.equalsIgnoreCase("s") ||
                    option.equalsIgnoreCase("b") ||
                    option.equalsIgnoreCase("sell") ||
                    option.equalsIgnoreCase("buy"));
        }else return (option.equalsIgnoreCase("b") ||
                option.equalsIgnoreCase("buy"));
    }



}
