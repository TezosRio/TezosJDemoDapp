package com.milfont.tezosj;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import milfont.com.tezosj.model.TezosWallet;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.plaf.ProgressBarUI;

import org.bitcoinj.core.AlertMessage;
import org.json.JSONObject;

import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Window.Type;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;

public class TezosJDemoDapp
{

   private JFrame frmTezosjDemoDapp;
   private JTextField txtPrivateKey;
   private JTextField txtPublicKey;
   private JTextField txtPublicKeyHash;
   private JTextField txtBalance;

   private TezosWallet wallet = null;
   private JTextField txtProvider;
   private JTextField txtSmartContractAddress;
   private JTextField txtCustomerName;
   private JTextField txtCustomerPhoneNumber;
   private JTextField txtCustomerID;
   private JTextField txtCustomerBalance;
   private JTextField txtRemoveID;
   private JTextField txtTransferFrom;
   private JTextField txtTransferTo;
   private JTextField txtUpdateID;
   private JTextField txtUpdateAmount;
   private JTextField txtTransferAmount;
   private JTextField txtOperationResult;

   /**
    * Launch the application.
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            try
            {
               TezosJDemoDapp window = new TezosJDemoDapp();
               window.frmTezosjDemoDapp.setVisible(true);
            } catch (Exception e)
            {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public TezosJDemoDapp()
   {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize()
   {
      frmTezosjDemoDapp = new JFrame();
      frmTezosjDemoDapp.setTitle("TezosJ Smart Contract Caller Demo dApp - v0.1");
      frmTezosjDemoDapp.setBounds(-19, -31, 800, 650);
      frmTezosjDemoDapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frmTezosjDemoDapp.getContentPane().setLayout(null);

      JLabel lblPrivateKey = new JLabel("Private key");
      lblPrivateKey.setBounds(10, 11, 308, 14);
      frmTezosjDemoDapp.getContentPane().add(lblPrivateKey);

      txtPrivateKey = new JTextField();
      txtPrivateKey.setBounds(10, 25, 735, 20);
      frmTezosjDemoDapp.getContentPane().add(txtPrivateKey);
      txtPrivateKey.setColumns(10);

      JLabel lblPublicKey = new JLabel("Public key");
      lblPublicKey.setBounds(10, 52, 308, 14);
      frmTezosjDemoDapp.getContentPane().add(lblPublicKey);

      txtPublicKey = new JTextField();
      txtPublicKey.setBounds(10, 68, 735, 20);
      frmTezosjDemoDapp.getContentPane().add(txtPublicKey);
      txtPublicKey.setColumns(10);

      JLabel lblPublicKeyHash = new JLabel("Public key hash");
      lblPublicKeyHash.setBounds(10, 100, 161, 14);
      frmTezosjDemoDapp.getContentPane().add(lblPublicKeyHash);

      txtPublicKeyHash = new JTextField();
      txtPublicKeyHash.setBounds(10, 114, 360, 20);
      frmTezosjDemoDapp.getContentPane().add(txtPublicKeyHash);
      txtPublicKeyHash.setColumns(10);

      JButton btnRestoreWallet = new JButton("Restore wallet");
      btnRestoreWallet.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent arg0)
         {

            if((txtPrivateKey.getText().isEmpty() == false) && (txtPublicKey.getText().isEmpty() == false)
                  && (txtPublicKeyHash.getText().isEmpty() == false))
            {
               try
               {
                  wallet = new TezosWallet(txtPrivateKey.getText(), txtPublicKey.getText(), txtPublicKeyHash.getText(),
                        "");
                  wallet.setProvider(txtProvider.getText());

                  txtBalance.setText(wallet.getBalance());
               } catch (Exception e)
               {
                  e.printStackTrace();
               }
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Private Key, Public Key and Public Key Hash are mandatory");
            }

         }
      });
      btnRestoreWallet.setBounds(10, 145, 148, 46);
      frmTezosjDemoDapp.getContentPane().add(btnRestoreWallet);

      JLabel lblBalance = new JLabel("Balance");
      lblBalance.setBounds(380, 140, 153, 14);
      frmTezosjDemoDapp.getContentPane().add(lblBalance);

      txtBalance = new JTextField();
      txtBalance.setHorizontalAlignment(SwingConstants.CENTER);
      txtBalance.setFont(new Font("Times New Roman", Font.PLAIN, 16));
      txtBalance.setEditable(false);
      txtBalance.setBounds(380, 153, 365, 38);
      frmTezosjDemoDapp.getContentPane().add(txtBalance);
      txtBalance.setColumns(10);

      JLabel lblProvider = new JLabel("Provider");
      lblProvider.setBounds(380, 99, 365, 14);
      frmTezosjDemoDapp.getContentPane().add(lblProvider);

      txtProvider = new JTextField();
      txtProvider.setBounds(380, 112, 365, 20);
      frmTezosjDemoDapp.getContentPane().add(txtProvider);
      txtProvider.setColumns(10);

      Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
      int height = screensize.height;
      int width = screensize.width;
      frmTezosjDemoDapp.setLocationRelativeTo(null);

      // Fill values.
      txtPrivateKey.setText(
            "edskRtWvdnNvKRdamLxTZHemgQHRWq6gkCXB5oY4fzrBkcGoD17umbEj5GN3tXKhcd2QdKM8kdbLQVVuW9wZrGV8Qem1hSkr7J");
      txtPublicKey.setText("edpktsYE1gXcFudYp2Lg2Jmx959qAeYduFG8e3qjA8Z9Xf9SVnoUdd");
      txtPublicKeyHash.setText("tz1YNRy5f4vWVWTY8nqhA9Q9P1CjTb8oby6g");
      txtProvider.setText("https://tezos-dev.cryptonomic-infra.tech");

      JPanel panelSmartContract = new JPanel();
      panelSmartContract.setBounds(10, 202, 735, 398);
      frmTezosjDemoDapp.getContentPane().add(panelSmartContract);
      panelSmartContract.setLayout(null);

      JLabel lblSmartContractAddress = new JLabel("Smart Contract Address");
      lblSmartContractAddress.setBounds(362, 7, 171, 14);
      panelSmartContract.add(lblSmartContractAddress);

      txtSmartContractAddress = new JTextField();
      txtSmartContractAddress.setHorizontalAlignment(SwingConstants.CENTER);
      txtSmartContractAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
      txtSmartContractAddress.setEditable(false);
      txtSmartContractAddress.setText("KT18pK2MGrnTZqyTafUe1sWp2ubJ75eYT86t");
      txtSmartContractAddress.setBounds(363, 22, 357, 27);
      panelSmartContract.add(txtSmartContractAddress);
      txtSmartContractAddress.setColumns(10);

      JPanel panel = new JPanel();
      panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
      panel.setBounds(10, 134, 715, 59);
      panelSmartContract.add(panel);
      panel.setLayout(null);

      JButton btnRemoveCustomer = new JButton("Remove Customer");
      btnRemoveCustomer.setBounds(505, 24, 169, 23);
      panel.add(btnRemoveCustomer);

      txtRemoveID = new JTextField();
      txtRemoveID.setBounds(386, 25, 100, 20);
      panel.add(txtRemoveID);
      txtRemoveID.setColumns(10);

      JLabel lblId_2 = new JLabel("ID");
      lblId_2.setBounds(386, 11, 61, 14);
      panel.add(lblId_2);
      btnRemoveCustomer.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            if(txtBalance.getText().isEmpty() == false)
            {

               if(txtRemoveID.getText().isEmpty() == false)
               {

                  try
                  {
                     txtOperationResult.setText("");
                     JSONObject jsonObject = wallet.callContractEntryPoint(wallet.getPublicKeyHash(),
                           txtSmartContractAddress.getText(), new BigDecimal(0), new BigDecimal(0.1), "", "",
                           "removeCustomer", new String[]
                     { txtRemoveID.getText() });
                     txtOperationResult.setText(jsonObject.getString("result").replace("\"", "").trim());
                  } catch (Exception f)
                  {
                     txtOperationResult.setText("There were errors. Transaction was not sent to the blockchain.");
                     f.printStackTrace();
                  }
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Customer ID to remove is mandatory");
               }
            }
            else
            {
               JOptionPane.showMessageDialog(null, "You have to restore your wallet first");
            }

         }
      });

      JPanel panel_1 = new JPanel();
      panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
      panel_1.setBounds(10, 204, 715, 59);
      panelSmartContract.add(panel_1);
      panel_1.setLayout(null);

      JButton btnTransfer = new JButton("Transfer");
      btnTransfer.setBounds(503, 22, 169, 23);
      panel_1.add(btnTransfer);

      txtTransferFrom = new JTextField();
      txtTransferFrom.setBounds(165, 23, 100, 20);
      panel_1.add(txtTransferFrom);
      txtTransferFrom.setColumns(10);

      JLabel lblFrom = new JLabel("From (ID)");
      lblFrom.setBounds(165, 9, 78, 14);
      panel_1.add(lblFrom);

      JLabel lblNewLabel_1 = new JLabel("To (ID)");
      lblNewLabel_1.setBounds(275, 9, 61, 14);
      panel_1.add(lblNewLabel_1);

      txtTransferTo = new JTextField();
      txtTransferTo.setBounds(275, 23, 100, 20);
      panel_1.add(txtTransferTo);
      txtTransferTo.setColumns(10);

      JLabel lblAmount = new JLabel("Amount (mutez)");
      lblAmount.setBounds(386, 9, 176, 14);
      panel_1.add(lblAmount);

      txtTransferAmount = new JTextField();
      txtTransferAmount.setBounds(386, 23, 100, 20);
      panel_1.add(txtTransferAmount);
      txtTransferAmount.setColumns(10);
      btnTransfer.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            if(txtBalance.getText().isEmpty() == false)
            {
               if((txtTransferFrom.getText().isEmpty() == false) && (txtTransferTo.getText().isEmpty() == false)
                     && (txtTransferAmount.getText().isEmpty() == false))
               {
                  try
                  {
                     txtOperationResult.setText("");
                     JSONObject jsonObject = wallet.callContractEntryPoint(wallet.getPublicKeyHash(),
                           txtSmartContractAddress.getText(), new BigDecimal(0), new BigDecimal(0.1), "", "",
                           "transfer", new String[]
                     { txtTransferAmount.getText(), txtTransferFrom.getText(), txtTransferTo.getText() });
                     txtOperationResult.setText(jsonObject.getString("result").replace("\"", "").trim());
                  } catch (Exception f)
                  {
                     txtOperationResult.setText("There were errors. Transaction was not sent to the blockchain.");
                     f.printStackTrace();
                  }

               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Fields transfer from, transfer to, and amount are mandatory");
               }
            }
            else
            {
               JOptionPane.showMessageDialog(null, "You have to restore your wallet first");
            }

         }
      });

      JPanel panel_2 = new JPanel();
      panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
      panel_2.setBounds(10, 274, 715, 59);
      panelSmartContract.add(panel_2);
      panel_2.setLayout(null);

      JButton btnUpdateBalance = new JButton("Update Balance");
      btnUpdateBalance.setBounds(501, 25, 169, 23);
      panel_2.add(btnUpdateBalance);

      JLabel lblId_1 = new JLabel("ID");
      lblId_1.setBounds(273, 11, 77, 14);
      panel_2.add(lblId_1);

      txtUpdateID = new JTextField();
      txtUpdateID.setBounds(273, 28, 100, 20);
      panel_2.add(txtUpdateID);
      txtUpdateID.setColumns(10);

      txtUpdateAmount = new JTextField();
      txtUpdateAmount.setBounds(384, 28, 100, 20);
      panel_2.add(txtUpdateAmount);
      txtUpdateAmount.setColumns(10);

      JLabel lblNewLabel_2 = new JLabel("Amount (mutez)");
      lblNewLabel_2.setBounds(384, 11, 115, 14);
      panel_2.add(lblNewLabel_2);
      btnUpdateBalance.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            if(txtBalance.getText().isEmpty() == false)
            {

               if((txtUpdateID.getText().isEmpty() == false) && (txtUpdateAmount.getText().isEmpty() == false))
               {
                  try
                  {
                     txtOperationResult.setText("");
                     JSONObject jsonObject = wallet.callContractEntryPoint(wallet.getPublicKeyHash(),
                           txtSmartContractAddress.getText(), new BigDecimal(0), new BigDecimal(0.1), "", "",
                           "updateBalance", new String[]
                     { txtUpdateAmount.getText(), txtUpdateID.getText() });
                     txtOperationResult.setText(jsonObject.getString("result").replace("\"", "").trim());
                  } catch (Exception f)
                  {
                     txtOperationResult.setText("There were errors. Transaction was not sent to the blockchain.");
                     f.printStackTrace();
                  }

               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Update ID and Amount fields are mandatory");
               }
            }
            else
            {
               JOptionPane.showMessageDialog(null, "You have to restore your wallet first");
            }

         }
      });

      JPanel panel_3 = new JPanel();
      panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
      panel_3.setBounds(170, 348, 501, 40);
      panelSmartContract.add(panel_3);
      panel_3.setLayout(null);

      txtOperationResult = new JTextField();
      txtOperationResult.setForeground(Color.BLUE);
      Font font = txtOperationResult.getFont();
      Map attributes = font.getAttributes();
      attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
      txtOperationResult.setFont(font.deriveFont(attributes));
      txtOperationResult.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            if(txtOperationResult.getText().isEmpty()==false)
            {
               Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
               if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
               {
                   try {
                     URI uri = new URI("https://better-call.dev/babylon/" + txtOperationResult.getText().trim());
                       desktop.browse(uri);
                       
                   } catch (Exception e) {
                       e.printStackTrace();
                   }}    
            }
         }
      });
      txtOperationResult.setEditable(false);
      txtOperationResult.setBounds(6, 6, 485, 26);
      panel_3.add(txtOperationResult);
      txtOperationResult.setHorizontalAlignment(SwingConstants.CENTER);

      JLabel lblOperationResult = new JLabel("Last Operation Result");
      lblOperationResult.setBounds(10, 361, 201, 14);
      panelSmartContract.add(lblOperationResult);

      JLabel lblNewLabel = new JLabel("Smart Contract Calling");
      lblNewLabel.setBounds(15, 7, 227, 26);
      panelSmartContract.add(lblNewLabel);
      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

      JPanel panelAdd = new JPanel();
      panelAdd.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

      panelAdd.setBounds(10, 64, 715, 59);
      panelSmartContract.add(panelAdd);
      panelAdd.setLayout(null);

      JLabel lblName = new JLabel("Name");
      lblName.setBounds(58, 11, 85, 14);
      panelAdd.add(lblName);

      txtCustomerName = new JTextField();
      txtCustomerName.setToolTipText("");
      txtCustomerName.setBounds(55, 25, 100, 20);
      panelAdd.add(txtCustomerName);
      txtCustomerName.setColumns(10);

      JLabel lblPhoneNumber = new JLabel("Phone Number");
      lblPhoneNumber.setBounds(168, 11, 132, 14);
      panelAdd.add(lblPhoneNumber);

      txtCustomerPhoneNumber = new JTextField();
      txtCustomerPhoneNumber.setBounds(165, 25, 100, 20);
      panelAdd.add(txtCustomerPhoneNumber);
      txtCustomerPhoneNumber.setColumns(10);

      JLabel lblId = new JLabel("ID");
      lblId.setBounds(275, 11, 86, 14);
      panelAdd.add(lblId);

      txtCustomerID = new JTextField();
      txtCustomerID.setBounds(275, 25, 100, 20);
      panelAdd.add(txtCustomerID);
      txtCustomerID.setColumns(10);

      JLabel lblBalance_1 = new JLabel("Balance (mutez)");
      lblBalance_1.setBounds(387, 11, 132, 14);
      panelAdd.add(lblBalance_1);

      txtCustomerBalance = new JTextField();
      txtCustomerBalance.setBounds(385, 25, 100, 20);
      panelAdd.add(txtCustomerBalance);
      txtCustomerBalance.setColumns(10);

      JButton btnAddCustomer = new JButton("Add Customer");
      btnAddCustomer.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent arg0)
         {
            if(txtBalance.getText().isEmpty() == false)
            {
               if((txtCustomerName.getText().isEmpty() == false)
                     && (txtCustomerPhoneNumber.getText().isEmpty() == false)
                     && (txtCustomerID.getText().isEmpty() == false)
                     && (txtCustomerBalance.getText().isEmpty() == false))
               {

                  try
                  {
                     txtOperationResult.setText("");
                     JSONObject jsonObject = wallet.callContractEntryPoint(wallet.getPublicKeyHash(),
                           txtSmartContractAddress.getText(), new BigDecimal(0), new BigDecimal(0.1), "", "",
                           "addCustomer", new String[]
                     { txtCustomerBalance.getText(), txtCustomerID.getText(), txtCustomerName.getText(), txtCustomerPhoneNumber.getText() });
                     txtOperationResult.setText(jsonObject.getString("result").replace("\"", "").trim());
                  } catch (Exception e)
                  {
                     txtOperationResult.setText("There were errors. Transaction was not sent to the blockchain.");
                     e.printStackTrace();
                  }
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Customer name, phone number, ID and balance, are mandatory");
               }
            }
            else
            {
               JOptionPane.showMessageDialog(null, "You have to restore your wallet first");
            }
         }
      });
      btnAddCustomer.setBounds(505, 24, 169, 23);
      panelAdd.add(btnAddCustomer);

   }
}
