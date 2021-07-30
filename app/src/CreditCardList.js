import React, { Component } from 'react';
import { Button, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';



class CreditCardList extends Component {

    constructor(props) {
        super(props);
        this.state = { creditCards: [], isLoading: true };
    }

    componentDidMount() {
        this.setState({ isLoading: true });

        fetch('/api/getCards')
            .then(response => response.json())
            .then(data => this.setState({ creditCards: data, isLoading: false }));
    }

    render() {
        const { creditCards, isLoading } = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const creditCardList = creditCards.map(card => {
            return <tr key={card.id}>
                <td style={{ whiteSpace: 'nowrap' }}>{card.userName}</td>
                <td style={{ whiteSpace: 'nowrap' }}>{card.creditCardNumber}</td>
                <td style={{ whiteSpace: 'nowrap' }}>{card.balance}</td>
                <td style={{ whiteSpace: 'nowrap' }}>{card.cardLimit}</td>
            </tr>
        });

        return (
            <div>
                <AppNavbar />
                <Container fluid responsive>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/api/add">Add Credit Card</Button>
                    </div>
                    <Table className="mt-4">
                        <thead>
                            <tr>
                                <th width="20%">Name</th>
                                <th width="20%">Card Number</th>
                                <th width="10%">Balance</th>
                                <th width="10%">Limit</th>

                            </tr>
                        </thead>
                        <tbody>
                            {creditCardList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default CreditCardList;