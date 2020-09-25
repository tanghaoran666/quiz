import React, { Component } from "react";
import "./Add.css";

class Add extends Component {
  state = {
    name: '',
    price: '',
    size: '',
    url: '',
  }
  
  handleChange= (event) => {
    event.preventDefault();
    this.setState(
      {[event.target.name] : event.target.value}
      )
  }
  handleSubmit= (event) => {
    event.preventDefault();
    console.log(JSON.stringify(this.state));
    
  }
  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          * 名称:<br />
          <input type="text" name="name" onChange={this.handleChange} value={this.state.name} placeholder='your name' className='input' />
        </label><br />
        <label>
        * 价格:<br />
          <input type="text" name="price" onChange={this.handleChange} value={this.state.name} placeholder='your name' className='input' />
        </label><br />
        <label>
          * 单位:<br />
          <input type="text" name="name" onChange={this.handleChange} value={this.state.name} placeholder='your name' className='input' />
        </label><br />
        <label>
          * 图片:<br />
          <input type="text" name="name" onChange={this.handleChange} value={this.state.name} placeholder='your name' className='input' />
        </label>
        <br />
        <input type='submit' value='Submit' disabled={!this.state.name || !this.state.gender || !this.state.descriptions || !this.state.isRead} />
      </form>
    );
  }
}

export default Add;
