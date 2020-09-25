import React, { Component } from 'react';
import './App.css';
import Header from './components/Header';
import {BrowserRouter as Router,Redirect,Route,Switch} from 'react-router-dom';
import Home from './components/Home'
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
      const data = await fetch('http://localhost:3000/products');
      const result = await data.json();
      this.setState({ products: result });
    } catch (err) {
      console.log(err);
    }
  }

  handleCart = () => {
    this.setState({ orders: this.state.orders });
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
        </Switch>
        </main>
      </div>
      </Router>
    );
  }
}

export default App;
