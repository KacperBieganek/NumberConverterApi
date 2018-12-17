# NumberConverterApi

## Requirements

* Java 8
* Maven 3.0+

## Running the API

If you have both Java and Maven installed just run `run.sh` script. It will build runnable jar (if not present already)
and run it.

To stop application just run `stop.sh` script.

## Example usage

Application runs at `localhost:4567`, converter is available at `/converter` route. 
It expects to receive 2 parameters `type` which is type of conversion and `number` which is a decimal digit (or positive decimal digit for Roman conversion).

Available types of conversions:
* HEX
* ROMAN
Example usage:
```
localhost:4567/converter?type=HEX&number=255
```