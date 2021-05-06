# Credit Booth Application

Foobar is a Python library for dealing with word pluralization.

## Run Application Locally

 title Local setup

1. Run an instance of eureka (service)
2. Open Credit booth project in intellj 
3. Go to **Run**, click **Edit Configuration**, and add **SPRING_PROFILES_ACTIVE=local** under **Environment Variables**



Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
pip install foobar
```



## Usage

```python
import foobar

foobar.pluralize('word') # returns 'words'
foobar.pluralize('goose') # returns 'geese'
foobar.singularize('phenomena') # returns 'phenomenon'
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)