| API Spec | v0.1.0 |
|-|-|

<br>

**Table Of Contents**
- [**createUser** (incomplete)](#createuser-incomplete)
  - [**Request**](#request)
  - [**Responses**](#responses)
- [**getUser** (incomplete)](#getuser-incomplete)
  - [Request](#request-1)
  - [Responses](#responses-1)
- [**editUser** (NOT STARTED)](#edituser-not-started)
  - [Request](#request-2)
  - [Responses](#responses-2)
- [**deleteUser** (incomplete)](#deleteuser-incomplete)
  - [Request](#request-3)
  - [Responses](#responses-3)
- [**addUserInstrument** (NOT STARTED)](#adduserinstrument-not-started)
  - [Request](#request-4)
  - [Responses](#responses-4)
- [**deleteUserInstrument** (NOT STARTED)](#deleteuserinstrument-not-started)
  - [Request](#request-5)
  - [Responses](#responses-5)
- [**addUserGenre** (NOT STARTED)](#addusergenre-not-started)
  - [Request](#request-6)
  - [Responses](#responses-6)
- [**deleteUserGenre** (NOT STARTED)](#deleteusergenre-not-started)
  - [Request](#request-7)
  - [Responses](#responses-7)
- [**getUsers** (incomplete)](#getusers-incomplete)
  - [Request](#request-8)
  - [Responses](#responses-8)

---
---
<br>

# **createUser** (incomplete)

Create a new user.

## **Request**

### POST /user/

#### URL

> None

#### Body - application/json

> **birthdate** date *required*  
> **email** string *required*  
> **experience** integer *required*  
> **location_city** string *required*  
> **location_state** string *required*  
> **location_zipcode** integer *required*  
> **name_first** string *required*  
> **name_last** string *required*  

## **Responses**

### 201 CREATED
#### Body - application/json

> **user_id** integer  
> **birthdate** date  
> **email** string  
> **experience** integer  
> **genres** array of objects  
> > empty  
>  
> **instruments** array of objects  
> > empty  
> 
> **location_city** string  
> **location_state** string  
> **location_zipcode** integer  
> **name_first** string  
> **name_last** string  

### 400 BAD REQUEST (NOT STARTED)
#### Body - application/json
> **error** object  
> > ***status*** integer  
> > ***message*** string  

---
---
<br>

# **getUser** (incomplete)

Get user identified by their unique user_id.

## Request

### GET /user/{id}

#### Url

> **id** integer

#### Body

> None

## Responses

### 200 OK

#### Body - application/json

> **user_id** integer  
> **birthdate** date  
> **email** string  
> **experience** integer  
> **genres** array of objects  
> > **genre_id** integer  
> > **name** string  
>
> **instruments** array of objects  
> > **instrument_id** integer  
> > **name** string  
> > **type** string  
>
> **location_city** string  
> **location_state** string  
> **location_zipcode** integer  
> **name_first** string  
> **name_last** string  

### 404 NOT FOUND (NOT STARTED)
 
#### Body - application/json
> **error** object  
> > ***status*** integer  
> > ***message*** string  

---
---
<br>

# **editUser** (NOT STARTED)

Edit attributes of an existing user identified by their unique user_id.

## Request
### PATCH /user/{id}

#### Url

> **id** integer

#### Body - application/json

> **birthdate** date *optional*  
> **email** string *optional*  
> **experience** integer *optional*  
> **location_city** string> *optional*  
> **location_state** string *optional*  
> **location_zipcode** integer *optional*  
> **name_first** string *optional*  
> **name_last** string *optional*  

## Responses

### 200 OK
#### Body - application/json

> **user_id** integer  
> **birthdate** date  
> **email** string  
> **experience** integer  
> **genres** array of objects  
> > **genre_id** integer  
> > **name** string  
>
> **instruments** array of objects  
> > **instrument_id** integer  
> > **name** string  
> > **type** string  
>
> **location_city** string  
> **location_state** string  
> **location_zipcode** integer  
> **name_first** string  
> **name_last** string  

### 400 BAD REQUEST (NOT STARTED)
#### Body - application/json
> **error** object
> > ***status*** integer  
> > ***message*** string  

---
---
<br>

# **deleteUser** (incomplete)

Delete an existing user identified by their unique user_id.

## Request
### DELETE /user/{id}

#### Url

> **id** integer

#### Body

> None

## Responses

### 204 NO CONTENT
#### Body
> None

### 404 NOT FOUND (NOT STARTED)
 
#### Body - application/json
> **error** object
> > ***status*** integer  
> > ***message*** string  

---
---
<br>

# **addUserInstrument** (NOT STARTED)

Add instrument for user identified by their unique user_id.

## Request

### POST /user/{user_id}/instrument/

#### Url

> **user_id** integer

#### Body - application/json

> **instrument_id** integer

## Responses

### 201 CREATED

#### Body - application/json

> **user_id** integer  
> **birthdate** date  
> **email** string  
> **experience** integer  
> **genres** array of objects  
> > **genre_id** integer  
> > **name** string  
>
> **instruments** array of objects  
> > **instrument_id** integer  
> > **name** string  
> > **type** string  
>
> **location_city** string  
> **location_state** string  
> **location_zipcode** integer  
> **name_first** string  
> **name_last** string

### 404 NOT FOUND (NOT STARTED)
 
#### Body - application/json
> **error** object  
> > ***status*** integer  
> > ***message*** string  

---
---
<br>

# **deleteUserInstrument** (NOT STARTED)

Delete instrument for user identified by their unique user_id.

## Request

### DELETE /user/{user_id}/instrument/{instrument_id}

#### Url

> **user_id** integer  
> **instrument_id** integer *optional* [^1]   
> > *if instrument_id is left blank, all user/instrument relationships will be removed from this user*

#### Body - application/json

> None

## Responses

### 200 OK

#### Body - application/json

> **user_id** integer  
> **birthdate** date  
> **email** string  
> **experience** integer  
> **genres** array of objects  
> > **genre_id** integer  
> > **name** string  
>
> **instruments** array of objects  
> > **instrument_id** integer  
> > **name** string  
> > **type** string  
>
> **location_city** string  
> **location_state** string  
> **location_zipcode** integer  
> **name_first** string  
> **name_last** string

### 404 NOT FOUND (NOT STARTED)
 
#### Body - application/json
> **error** object  
> > ***status*** integer  
> > ***message*** string  

---
---
<br>

# **addUserGenre** (NOT STARTED)

Add genre for user identified by their unique user_id.

## Request

### POST /user/{user_id}/instrument/

#### Url

> **user_id** integer

#### Body - application/json

> **genre_id** integer

## Responses

### 201 CREATED

#### Body - application/json

> **user_id** integer  
> **birthdate** date  
> **email** string  
> **experience** integer  
> **genres** array of objects  
> > **genre_id** integer  
> > **name** string  
>
> **instruments** array of objects  
> > **instrument_id** integer  
> > **name** string  
> > **type** string  
>
> **location_city** string  
> **location_state** string  
> **location_zipcode** integer  
> **name_first** string  
> **name_last** string

### 404 NOT FOUND (NOT STARTED)
 
#### Body - application/json
> **error** object  
> > ***status*** integer  
> > ***message*** string  

---
---
<br>

# **deleteUserGenre** (NOT STARTED)

Delete genre for user identified by their unique user_id.

## Request

### DELETE /user/{user_id}/genre/{genre_id}

#### Url

> **user_id** integer  
> **genre_id** integer *optional* [^1]   
> > *if genre_id is left blank, all user/genre relationships will be removed from this user*

#### Body - application/json

> None

## Responses

### 200 OK

#### Body - application/json

> **user_id** integer  
> **birthdate** date  
> **email** string  
> **experience** integer  
> **genres** array of objects  
> > **genre_id** integer  
> > **name** string  
>
> **instruments** array of objects  
> > **instrument_id** integer  
> > **name** string  
> > **type** string  
>
> **location_city** string  
> **location_state** string  
> **location_zipcode** integer  
> **name_first** string  
> **name_last** string

### 404 NOT FOUND (NOT STARTED)
 
#### Body - application/json
> **error** object  
> > ***status*** integer  
> > ***message*** string  

---
---
<br>

# **getUsers** (incomplete)

Get all users

## Request

### GET /users/

#### Url

> None

#### Body

> None

## Responses

### 200 OK

#### Body - application/json

> **users** array of objects  
> > **user_id** integer  
> > **birthdate** date  
> > **email** string  
> > **experience** integer  
> > **genres** array of objects  
> > > **genre_id** integer  
> > > **name** string  
> >  
> > **instruments** array of objects  
> > > **instrument_id** integer  
> > > **name** string  
> > > **type** string  
> >  
> > **location_city** string  
> > **location_state** string  
> > **location_zipcode** integer  
> > **name_first** string  
> > **name_last** string  


