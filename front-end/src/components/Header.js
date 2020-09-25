import React from "react";
import { NavLink} from 'react-router-dom';
import './Header.css';

class Header extends React.Component{
    render(){
        return <div className='links'>
            <div className='linkBlock'>
            
            <div className='link'>
            <NavLink className='menu-link' exact to="/" activeStyle={{backgroundColor:"royalblue"}}>商城</NavLink>
            </div>
            <div className='link'>
            <NavLink className='menu-link' to="/order" activeStyle={{backgroundColor:"royalblue"}}>订单</NavLink>
            </div>
            <div className='link'>
            <NavLink className='menu-link' to="/add" activeStyle={{backgroundColor:"royalblue"}}>添加商品</NavLink>
            </div>
            
            </div>
        </div>
    }
}

export default Header;