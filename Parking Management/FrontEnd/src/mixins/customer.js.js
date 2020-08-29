import DataService from '../auth-axios';

export const customer = {
  data() {
    return {
      customer: [],
    };
  },
  methods: {
    getCustomers() {
      DataService.retrieveAllCustomers().then((res) => {
        const data = res.data;
        const users = [];
        for (let key in data) {
          const user = data[key];
          users.push(user);
        }
        this.customers = users;
      });
    },
  },
  created() {
    this.getCustomers();
  },
};
