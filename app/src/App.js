import React, { Component } from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CreditCardList from './CreditCardList';
import AddCreditCard from './AddCreditCard';

class App extends Component {
  render() {
    return (

      <Router>
        <Switch>
          <Route path='/' exact={true} component={CreditCardList} />
          <Route path='/api/add' exact={true} component={AddCreditCard} />
        </Switch>
      </Router>

    )
  }
}

export default App;