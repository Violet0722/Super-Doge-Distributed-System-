<template>
  <div class="main">
    <div id="header-logo">
      <h1>Super Doge Benefit System</h1>
      <p>Redeem your points for products!</p>
      <p>Delivering to your home!</p>
    </div>
    <div>
      <select @change="changeUser($event)">
        <option value="">please select a member</option>
        <option v-for="m in members" :key="m.id" :value="m.id">
          {{ m.name }}
        </option>
      </select>

      <div id="left">
        <br />
        <br />
        <table id="products">
          <thead>
            <tr>
              <th>Name</th>
              <th>Category</th>
              <th>Points</th>
              <th>Redeem</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="p in products" :key="p.id">
              <td>{{ p.name }}</td>
              <td>{{ p.category }}</td>
              <td>{{ p.price }}</td>
              <td>
                <button v-on:click="submit(p)">buy</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <div id="right">
        <br />
        <div
          id="profile-card"
          v-show="currentMember != null && currentMember.id != null"
        >
          <p>Name: {{ currentMember.name }}</p>
          <p>Left Points: {{ currentMember.points }}</p>
          <p>Address: {{ currentMember.address }}</p>
          <p>Contact: {{ currentMember.phoneNumber }}</p>
        </div>

        <br />
        <div
          id="orders-card"
          v-show="
            currentMember != null &&
            currentMember.id != null &&
            previousOrders != null &&
            previousOrders[0] != null
          "
        >
          <p style="text-align: left">Your previous orders:</p>
          <div v-for="o in previousOrders" :key="o.orderId">
            <p>
              You redeemed {{ o.costPoints }} points to buy {{ o.productName }},
            </p>
            <p>delivering on {{ o.deliveryTime }} by {{ o.deliveryCompany }}</p>
            <hr />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
#header-logo {
  text-align: center;
  color: green;
}

#left {
  width: 30%;
  padding-left: 15%;
  float: left;
}

#right {
  float: right;
  width: 45%;
  margin-right: 5%;
}

#products {
  border-collapse: collapse;
  width: 100%;
}

#products td,
#products th {
  border: 1px solid #ddd;
  padding: 8px;
}

#products tr:nth-child(even) {
  background-color: #f2f2f2;
}

#products tr:hover {
  background-color: #ddd;
}

#products th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #04aa6d;
  color: white;
}

#profile-card {
  border: 1px solid;
  text-align: left;
  margin-left: 20%;
  margin-right: 30%;
  padding-left: 5%;
}

#orders-card {
  text-align: left;
  margin-left: 20%;
  margin-right: 20%;
}
</style>

<script >
import axios from "axios";

export default {
  name: "benefit",

  data() {
    return {
      products: [],
      currentMemberId: 1,
      members: [],
      currentMember: Object,
      previousOrders: [],
      orderCounts: String,
    };
  },

  mounted() {
    this.getProducts();
    this.getAllMembers();
    this.getOrdersCount();
  },

  methods: {
    getProducts() {
      axios
        .get("http://localhost:8001/products", {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods":
              "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers":
              "Origin, Content-Type, X-Auth-Token",
          },
        })
        .then((response) => {
          this.products = response.data;
        });
    },

    getAllMembers() {
      axios
        .get("http://localhost:8101/members", {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods":
              "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers":
              "Origin, Content-Type, X-Auth-Token",
          },
        })
        .then((response) => {
          this.members = response.data;
        });
    },

    getCurrentMemberProfile() {
      this.currentMember = this.members[this.currentMemberId - 1];
    },

    getCurrentMemberOrders() {
      if (this.currentMember != null && this.currentMember.id != null) {
        axios
          .get("http://localhost:8001/order/" + this.currentMember.id, {
            headers: {
              "Access-Control-Allow-Origin": "*",
              "Access-Control-Allow-Methods":
                "GET, POST, PATCH, PUT, DELETE, OPTIONS",
              "Access-Control-Allow-Headers":
                "Origin, Content-Type, X-Auth-Token",
            },
          })
          .then((response) => {
            this.previousOrders = response.data;
          });
      }
    },

    getOrdersCount() {
      axios
        .get("http://localhost:8001/orders", {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods":
              "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers":
              "Origin, Content-Type, X-Auth-Token",
          },
        })
        .then((response) => {
          this.orderCounts = response.data;
        });
    },

    submit(product) {
      var count = parseInt(this.orderCounts);
      var reqBody = {
        orderId: ++count,
        memberId: this.currentMemberId,
        productName: product.name,
        costPoints: product.price,
        previousPoints: this.currentMember.points,
      };
      axios
        .post("http://localhost:8001/order", reqBody, {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods":
              "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers":
              "Origin, Content-Type, X-Auth-Token",
          },
        })
        .then();
      this.getOrdersCount();
      this.getAllMembers();
    },

    changeUser(event) {
      this.currentMemberId = event.target.value;
      this.getCurrentMemberProfile();
      this.getCurrentMemberOrders();
    },
  },
};
</script>

<style scoped>
</style>
