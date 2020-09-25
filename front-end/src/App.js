import React, { Component } from 'react';
import './App.css';
import Header from './components/Header';
import {BrowserRouter as Router,Redirect,Route,Switch} from 'react-router-dom';
import Home from './components/Home'
import Orders from './components/Orders';
import Add from './components/Add';
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      goods: [{
        name:'可乐1',
        price:1,
        url:'./../assets/product_image_placeholder.png'
      },{
        name:'可乐2',
        price:1,
        url:'./../assets/product_image_placeholder.png'
      },{
        name:'可乐3',
        price:1,
        url:'./../assets/product_image_placeholder.png'
      },{
        name:'可乐4',
        price:1,
        url:'./../assets/product_image_placeholder.png'
      },{
        name:'可乐5',
        price:1,
        url:'./../assets/product_image_placeholder.png'
      }],
      orders: []
    };
  }
  
  async componentDidMount() {
    try {
      const data = await fetch("http://localhost:3306/good",{
        method:"GET",
      });
      const result = await data.json();
      console.log(JSON.stringify(result));

      this.setState({ goods: result });
    } catch (err) {
      console.log(err);
    }
  }

  handleCart = (name) => {
    const orders = [];
    const good = this.state.goods.find((good) => good.name ===name)
    this.setState({ orders: this.state.orders.push({...good,number:1}) });
  };

  render() {
    return (
      <Router>
      <div className="all">
        <main className="app">
        <Header />
        <Switch>
        <Route exact path='/' >
          <Home goods={this.state.goods} />
        </Route>
        <Route exact path='/order' >
          <Orders />
        </Route>
        <Route exact path='/add' >
          <Add />
        </Route>
        </Switch>
        </main>
      </div>
      </Router>
    );
  }
}

export default App;
