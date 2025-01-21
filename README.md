# CarGallerist 

This repository contains a **simple car trading system** developed while learning **Spring Framework**. 🚗  

## Features  
- **User Accounts**: Customers can log in and request to purchase cars from registered dealerships.  
- **Currency Conversion**:  
  - Supports transactions in **USD** or **TRY**.  
  - Integrates with the **Central Bank API** for live exchange rates.  
- **Dynamic Dealerships**: Each dealership has its own currency preferences.  

## How It Works  
1. Users browse registered dealerships and select a car.  
2. The system checks the dealership's accepted currency (USD/TRY).  
3. If a conversion is needed, the system fetches the current rate from the Central Bank's API and processes the transaction.  

## Technologies Used  
- **Spring Framework**  
- **RESTful API**  
- **Central Bank API**  

**Additional Note:** Only single operations (e.g., save) are implemented in the services, and the entire project is not fully developed. This is a trial project.
