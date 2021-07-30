import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class AddCreditCard extends Component {

    emptyItem = {
        userName: '',
        creditCardNumber: '',
        cardLimit: '',
    };

    saveEnable = false;
    successMessage = '';
    errorMessage = '';

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem

        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        //const card = await (await fetch(`/api/add`)).json();
        // this.setState({item: card});

    }

    handleChange(event) {
        const target = event.target;
        const name = target.name;
        let value = '';
        if (name === "creditCardNumber" || name === "cardLimit") {
            value = target.value.replace(/\D/, '')
            value = value.slice(0, 19)
        }
        else
            value = target.value.slice(0, 32);
        let item = { ...this.state.item };
        item[name] = value;
        this.setState({ item });
        if (item.cardLimit && item.userName && item.creditCardNumber)
            this.saveEnable = true;
        else
            this.saveEnable = false;
    }

    async handleSubmit(event) {
        event.preventDefault();
        const { item } = this.state;

        await fetch('/api/add', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        }).then((resp) => {
            if (resp.status === 500) {
                Promise.resolve(resp.text()).then((res) => {
                    throw new Error(res);
                }).catch((e) => {
                    console.log(e)

                })
                this.errorMessage = "Please Enter Valid Credit Card Details";
            }
            else {
                this.successMessage = "Credit Card added Successfully";
            }
            console.log(this.errorMessage)
        })
        this.props.history.push('/');
    }


    render() {
        const { item } = this.state;
        const title = <h4>{'Add Credit Card'}</h4>;
        const errorMessage = this.errorMessage;
        console.log(this.errorMessage)
        const alertShow = "alert alert-danger fade show"
        const alertHide = "close"
        const show = errorMessage !== '' ? alertShow : alertHide;

        return <div>
            <AppNavbar />
            <Container >

                <div className="row">
                    <div className="col-4"> {title} </div>
                    <div className="col-8" role="alert" className={show}>
                        {errorMessage}
                    </div>
                </div>

                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="userName">Name</Label>
                        <Input type="text" name="userName" id="userName" value={item.userName || ''}
                            onChange={this.handleChange} autoComplete="userName" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="creditCardNumber">Card Number</Label>
                        <Input type="text" pattern="[0-9]*" name="creditCardNumber" id="creditCardNumber" value={item.creditCardNumber || ''}
                            onChange={this.handleChange} autoComplete="creditCardNumber" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="cardLimit">Limit</Label>
                        <Input type="text" pattern="[0-9]*" name="cardLimit" id="cardLimit" value={item.cardLimit || ''}
                            onChange={this.handleChange} autoComplete="cardLimit" />
                    </FormGroup>
                    <div></div>
                    <FormGroup>
                        <Button color="primary" type="submit" disabled={!this.saveEnable} >Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }
}

export default withRouter(AddCreditCard);