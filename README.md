## TezosJDemoDapp
A Tezos dApp that interacts with a testnet smart contract

## Introduction

TezosJ Demo dApp is a desktop application that interacts with a smart contract deployed on Tezos testnet. It uses TezosRio's
TezosJ_plainJava library to communicate with the Tezos blockchain.

This demo dApp uses a contract deployed on the address KT18pK2MGrnTZqyTafUe1sWp2ubJ75eYT86t . This is a public contract
that represents a list of a fictional company's customers. You may change the list at will.

The smart contract has four entrypoints: addCustomer, removeCustomer, transfer and updateBalance. Each one has its set of
parameters. When calling the contract, the parameter order should be observed, otherwise it will fail.

The dApp already comes with a testnet private/public key set, but you may use your own set of keys. There is no point in
using mainnet private keys, as the contract does not exist on mainnet, although the code works with any Tezos network. You
can change the network through the command wallet.setProvider("https://myProvider");

## Objective

This software was written for educational purposes. Its main goal is to inspire developers to easily create applications
that interacts and communicates with Tezos blockchain. As the TezosJ_library is essentially a JAR file, any language that
can import a JAR may be able to use it.

## Compatibility

If you generate a runnable JAR from the project, it will run on any system that supports Java (has a Java runtime environment):
Windows, Linux or even Mac.

## Getting the executable.

If you just want to run and test the application, you may download the runnable JAR (executable) from the Medium article:
[TezosJ Smart Contract caller demo dApp](https://medium.com/@lmilfont/tezosj-smart-contract-caller-demo-dapp-b1cb808c1d2e).
You, then, run the JAR in a command prompt, through the command: java -jar TezosJDemoDapp.jar


## Requirements

- Java 8
- Windows / Linux / Mac

## Usage

Clone the repository, import the project in your Eclipse IDE, click the project name and run.

