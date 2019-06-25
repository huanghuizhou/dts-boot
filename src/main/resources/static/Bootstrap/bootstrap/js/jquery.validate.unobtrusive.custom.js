(function ($) {
    $.validator.addMethod('requiredif',
        function (value, element, parameters) {
            var id = '#' + parameters['dependentproperty'];
            // get the target value (as a string,
            // as that's what actual value will be)
            var targetvalue = parameters['targetvalue'];
            targetvalue = (targetvalue == null ? '' : targetvalue).toString();

            var targetvaluearray = targetvalue.split('|');

            // get the actual value of the target control
            // note - this probably needs to cater for more
            // control types, e.g. radios
            var control = $(id);
            var controltype = control.attr('type');
            var actualvalue =
                controltype === 'checkbox' ?
                    control.attr('checked') ? "true" : "false" :
                    control.val();

            for (var i = 0; i < targetvaluearray.length; i++) {

                // if the condition is true, reuse the existing
                // required field validator functionality
                if (targetvaluearray[i] === actualvalue) {
                    return $.validator.methods.required.call(this, value, element, parameters);
                }
            }

            return true;
        }
    );

    $.validator.addMethod('requiredifnot',
        function (value, element, parameters) {
            var id = '#' + parameters['dependentproperty'];
            // get the target value (as a string,
            // as that's what actual value will be)
            var targetvalue = parameters['targetvalue'];
            targetvalue = (targetvalue == null ? '' : targetvalue).toString();

            var targetvaluearray = targetvalue.split('|');

            // get the actual value of the target control
            // note - this probably needs to cater for more
            // control types, e.g. radios
            var control = $(id);
            var controltype = control.attr('type');
            var actualvalue =
                controltype === 'checkbox' ?
                    control.attr('checked') ? "true" : "false" :
                    control.val();

            var ifnot = true;

            for (var i = 0; i < targetvaluearray.length; i++) {

                // if the condition is true, reuse the existing
                // required field validator functionality
                if (targetvaluearray[i] === actualvalue) {
                    ifnot = false;
                    break;
                }
            }

            if (ifnot) {
                return $.validator.methods.required.call(this, value, element, parameters);
            }

            return true;
        }
    );

    $.validator.addMethod('charset',
        function (value, element, parameters) {
            var maxlength = parameters['maxlength'];

            if (GB18030ByteCount(value) > maxlength) {
                return false;
            }

            return true;
        }
    );

    $.validator.unobtrusive.adapters.add(
        'requiredif',
        ['dependentproperty', 'targetvalue'],
        function (options) {
            options.rules['requiredif'] = {
                dependentproperty: options.params['dependentproperty'],
                targetvalue: options.params['targetvalue']
            };
            options.messages['requiredif'] = options.message;
        });

    $.validator.unobtrusive.adapters.add(
        'requiredifnot',
        ['dependentproperty', 'targetvalue'],
        function (options) {
            options.rules['requiredifnot'] = {
                dependentproperty: options.params['dependentproperty'],
                targetvalue: options.params['targetvalue']
            };
            options.messages['requiredifnot'] = options.message;
        });

    $.validator.unobtrusive.adapters.add(
        'charset',
        ['maxlength'],
        function (options) {
            options.rules['charset'] = {
                maxlength: options.params['maxlength']
            };
            options.messages['charset'] = options.message;
        });

    function GB18030ByteCount(inputvalue) {
        var count = 0;
        var index = 0;
        var charCode;
        while (index < inputvalue.length) {
            charCode = inputvalue.charCodeAt(index);
            if (charCode >= 0x00000000 && charCode <= 0x0000007F) {
                count++;
            }
            else {
                count += 2;
            }
            index++;
        }
        return count;
    }

}(jQuery));