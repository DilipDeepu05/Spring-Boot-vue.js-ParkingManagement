import axios from 'axios';

const PARKING = 'parking';
const PARK_URL = 'http://localhost:8080';
const PARK_API_URL = `${PARK_URL}/${PARKING}`;

class DataService {
  retrieveAllCustomers() {
    return axios.get(`${PARK_API_URL}/customer`);
  }
  retrieveAllBilling() {
    return axios.get(`${PARK_API_URL}/Billing`);
  }
  retrieveCustomer(CustomerId) {
    return axios.get(`${PARK_API_URL}/search/${CustomerId}`);
  }
  addCustomer(Customer) {
    axios.post(`${PARK_API_URL}/customer`, Customer);
  }
  updateCustomer(Customer) {
    axios.post(`${PARK_API_URL}/customer`, Customer);
  }
  activeBilling(CustomerId) {
    axios.post(`${PARK_API_URL}/activeBilling/${CustomerId}`);
  }
}

export default new DataService();
