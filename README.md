
# Employee API

The simple Employee API performs basic CRUD operations against an H2 in-memory database. 


## API Reference

#### Get all Employees

```markdown
   GET /getEmployees
```

#### Get Employee by ID

```markdown
  GET /getEmployeeById/{id}
```

| Parameter | Type     | Description                       | Required |
| :-------- | :------- | :-------------------------------- | :--------|
| `id`      | `string` |Id of employee to fetch |  **Yes** |

#### Add Employee

```markdown
  POST /addEmployee
```

| Parameter | Type     | Description                       | Required |
| :-------- | :------- | :-------------------------------- | :--------| 
| `id`      | `string` | auto-generated | **Yes** |
| `firstName`      | `string` | First Name of Employee | **No** |
| `id`      | `string` | Last Name of Employee | **No** |
| `id`      | `string` | Email of Employee | **No** |

#### Update Employee

```markdown
  POST /updateEmployeeById/{id}
```

| Parameter | Type     | Description                       | Required |
| :-------- | :------- | :-------------------------------- | :--------|
| `id`      | `string` |Id of Employee to update |  **Yes** |

#### Delete Employee

```markdown
  DELETE /deleteEmployeeById/{id}
```

| Parameter | Type     | Description                       | Required |
| :-------- | :------- | :-------------------------------- | :--------|
| `id`      | `string` |Id of Employee to delete |  **Yes** |

## Run Locally

1. Clone the project

```bash
  git clone https://link-to-project
```

2. Go to the project directory

```bash
  cd firstApp
```

3. Run FirstAppApplication.java and in a browser hit:

```bash
  http://localhost:8080/h2
```

4. Check the `EMPLOYEES` database is being created (will be empty on startup)
5. Perform Create operation to add Employee records to the database (can be empty record as of 8/26/2025)
6. Perform any other CRUD operation to manipulate data

Example Request to Add Employee for easy access:
```markdown
  {
	"firstName": "Emily",
	"lastName": "Ng",
	"department": "MIAM",
	"jobTitle": "Info Security Engineer III",
	"dateOfBirth": "03-10-2000",
	"hireDate": "06-01-2022",
	"salary": "100000",
	"email": "eng0310@gmail.com"
}
```

