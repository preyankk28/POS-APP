# POS-APP
POSS app is an application for the PAC store to facilate funding to different organizations (Web Page for Reference https://helpmefund.org/anne).

I am the developer of the application , reach me out via email for more enquiries - preyankk28@gmail.com

![2021-02-15](https://user-images.githubusercontent.com/72382646/111074320-7723ce80-8508-11eb-99de-d152e5f79194.jpg)
![2021-02-21](https://user-images.githubusercontent.com/72382646/111074323-78ed9200-8508-11eb-9ff1-d092df7ea791.jpg)
![2021-02-08](https://user-images.githubusercontent.com/72382646/111074325-79862880-8508-11eb-8e74-a42c23fa355d.jpg)
![2021-02-08 (1)](https://user-images.githubusercontent.com/72382646/111074326-7a1ebf00-8508-11eb-88e7-7a42b51c2cb3.jpg)


![](https://img.shields.io/badge/VOLLEY-informational?style=flat&logo=<POS>&logoColor=white&color=2bbc8a)[](https://img.shields.io/badge/MaterialDesign-informational?style=flat&logo=<POS>&logoColor=white&color=2bbc8a)
![](https://img.shields.io/badge/Code-JAVA-informational?style=flat&logo=<POS>&logoColor=white&color=2bbc8a)
![](https://img.shields.io/badge/API-RETROFIT-informational?style=flat&logo=<POS>&logoColor=white&color=2bbc8a)
![](https://img.shields.io/badge/Editor-IntellijIdea-informational?style=flat&logo=<POS>&logoColor=white&color=2bbc8a)
![](https://img.shields.io/badge/ANDROID-informational?style=flat&logo=<POS>&logoColor=white&color=2bbc8a)



API's used in the application are-

POST API's

1.https://api.helpmefund.org/api/cases/665/donations/addposdonation

post parameter{
  "posid": "0821856517",
  "email": "santosh@odisoft.in",
  "firstName": "santosh",
  "lastName": "panigrahy",
  "phone": "string",
  "ipAddress": "string",
  "caseId": 665,
  "donationAmount": 10,
  "expirydate": "0222",
  "cardno": "4242424242424242",
  "cVcode": "123"
}

2. https://api.helpmefund.org/api/cases/665/donations/SynDonationInfo (used in the third page for sync user)


 {
  "email": "test@gmail.com",
  "firstName": "Test123",
  "lastName": "test456",
  "phone": "4578965878",
  "donationID": "HMF20210221-713-72",
  "remark": "Testingggggggggggg",
  "isAnonymous": true,
  "isRemarkPrivate": true
}

3.For OJC Donation API


{

  "posid": "0821856517",

   "numberOfPayment": 8,

  "platformFee": 0,

   "donationAmount": 20,

  "expirydate": "1226",

  "cardno": "6900662258537849",

  }
  
  4. https://api.helpmefund.org/api/Cases/665/Donations/AddPosMtdDonation (For MTD fix and split equally)
  
  {
 "caseId": 665,
   "expirydate": "0123",
 "cardno": "4242424242424242",
 "cVcode": "123",
  "donationAmount": 100,
 "posid": "0821856517",
  "platformPercent": 0,
   "pOSMTDDonationVMs": [
   {
     "teanId": "288",
     "memberId": 80
   },
   {
     "teanId": "288",
     "memberId": 81
   }
 ]
}

5.  https://api.helpmefund.org/api/Cases/665/Donations/AddPosMtdDonation (For some and custom amount)

{
 "caseId": 665,
 "isMTDCustome": true,
 "expirydate": "0224",
 "cardno": "4242424242424242",
 "cVcode": "123",
 "donationAmount": 100,
 "posid": "0821856517",
 "mTDDonationVMs": [
   {
     "teanId": "288",
     "amount": "100",
     "memberId": "80"
   }
 ]
}


6. https://api.helpmefund.org/api/Teams/GetTeamList (Get Team List in spinner)
(pos id - 0821856517
and send case id as - 665)

donationAmount
POSID
Card details all parameter
"mtdFixedAndSplitEqualy": [
   "string" (TeamId here)
 ],
 
 
7.https://api.helpmefund.org/api/cases/665/donations/addposdonation (For Recurring Donation)

{
 "posid": "0821856517",
 "caseId": 665,
 "donationAmount": 50,
 "expirydate": "0224",
 "cardno": "4242424242424242",
 "cVcode": "123",
 "paymentDate": "2021-03-19T04:43:03.756Z",
 "isChargeScheduled": true
}

8. https://api.helpmefund.org/api/cases/665/donations/addposdonation (For Schedule Donation)

{
 "posid": "0821856517",
 "numberOfPayment": 3,
 "scheduleInterval": "day",
 "isRecurring": true,
 "donationAmount": 100,
 "expirydate": "0224",
 "cardno": "4242424242424242",
 "cVcode": "123",
 "paymentDate": "2021-02-19T08:45:24.281Z",
 "isChargeScheduled": false
}


GET API's

1. https://api.helpmefund.org/api/Cases/665 (For Donation Labels , custom amount array in the API)

2. https://api.helpmefund.org/api/cases/665/donations/GetAllDonationForPOSByPosId?posId=0821856517 (History API)

3. https://api.helpmefund.org/api/Cases/{caseId}/Refunds (Refund Button API)
