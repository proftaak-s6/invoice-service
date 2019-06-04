package services;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import java.util.ArrayList;
import java.util.List;

public class PaypalService {

    private String iD = "<!---- Add your clientID Key here ---->";
    private String secret = "<!---- Add your clientSecret Key here ---->";
    private String cancelUrl= "http://mijn.rekeningrijden.fontys-project.nl/";
    private String redirectUrl = "http://portal.rekeningrijden.fontys-project.nl/";

    private String executionMode = "sandbox"; // sandbox or production

    public void capturePaypalAPI(){
        Payment payment = createPayment(1.1, 2.2, "EUR", 3.3);
        APIContext apiContext = new APIContext(iD, secret, executionMode);

        try {

            Payment myPayment = payment.create(apiContext);

            System.out.println("createdPayment Obejct Details ==> " + myPayment.toString());

            // Identifier of the payment resource created
            payment.setId(myPayment.getId());

            PaymentExecution paymentExecution = new PaymentExecution();

            // Set your PayerID. The ID of the Payer, passed in the `return_url` by PayPal.
            paymentExecution.setPayerId("<!---- Add your PayerID here ---->");

            // This call will fail as user has to access Payment on UI. Programmatically
            // there is no way you can get Payer's consent.
            Payment createdAuthPayment = payment.execute(apiContext, paymentExecution);

            // Transactional details including the amount and item details.
            Authorization authorization = createdAuthPayment.getTransactions().get(0).getRelatedResources().get(0).getAuthorization();

            System.out.println("Here is your Authorization ID" + authorization.getId());

        } catch (PayPalRESTException e) {

            // The "standard" error output stream. This stream is already open and ready to
            // accept output data.
            System.err.println(e.getDetails());
        }

    }

    private Payment createPayment(double taxDetails, double subTotalDetails, String currencyType, double total){
        Payment payment = new Payment();
        payment.setIntent("authorize");
        payment.setPayer(createPayer());
        payment.setTransactions(
                createTransaction(
                        createAmount(
                                createDetails(taxDetails, subTotalDetails), currencyType, total)));
        payment.setRedirectUrls(createRedirecrUrls());
        return payment;
    }

    private Payer createPayer(){
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        return payer;
    }

    private Details createDetails(double tax, double subTotal){
        Details details = new Details();
        details.setSubtotal(Double.toString(subTotal));
        details.setTax(Double.toString(tax));
        return details;
    }

    private Amount createAmount(Details details, String currency, double total){
        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setTotal(Double.toString(total));
        amount.setDetails(details);
        return amount;
    }

    private List<Transaction> createTransaction(Amount amount){
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Hier moet de transaction desc");
        transactions.add(transaction);
        return transactions;
    }

    private RedirectUrls createRedirecrUrls(){
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(redirectUrl);
        return redirectUrls;
    }
}
