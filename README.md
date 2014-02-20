TrendyHotels
============

See realtime most watched Hotels on [Booking.com][0] site.

##Disclaimer

I've coded this in a few days just to play a while with Booking.com API, this code is not intended to be released as a final product so there might be lot of bugs in there, and stuff that should be refactored.

##Setup

Project comes already configured to connect with a server instance already deployed on Heroku. Either way, it can be configured to point to a local instance. You can change this on `Settings.java` file.

##TODO's

The App currently reports a hardcoded location (New York, New York) for getting local Hotels. It shouldn't be much complicated to integrate with `LocationManager` to retrieve current location and send it to the Server, which supports an input of latitude and longitude to pull the data.

##Server

The server source is available to download [here][1].

License
=======

    The MIT License (MIT)
    
    Copyright (c) 2014 Diego Acosta
    
    Permission is hereby granted, free of charge, to any person obtaining a copy of
    this software and associated documentation files (the "Software"), to deal in
    the Software without restriction, including without limitation the rights to
    use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
    the Software, and to permit persons to whom the Software is furnished to do so,
    subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
    FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
    COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
    IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
    CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
    
[0]: http://www.booking.com/
[1]: https://github.com/dmacosta/TrendyHotelsServer
