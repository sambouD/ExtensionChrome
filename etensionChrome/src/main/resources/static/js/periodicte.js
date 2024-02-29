/**
 * 
 */

document.addEventListener('DOMContentLoaded', function() {
    var dailyRadio = document.getElementById('daily');
    var additionalOptions = document.getElementById('additionalOptions');

    var weeklyRadio = document.getElementById('weekly');
    var additionalOptionsWeekly = document.getElementById('additionalOptionsWeekly');

    dailyRadio.addEventListener('change', function() {
        additionalOptions.style.display = dailyRadio.checked ? 'block' : 'none';
        additionalOptionsWeekly.style.display = dailyRadio.checked ? 'none' : 'block';
    });

    weeklyRadio.addEventListener('change', function() {
        additionalOptionsWeekly.style.display = weeklyRadio.checked ? 'block' : 'none';
        additionalOptions.style.display = weeklyRadio.checked ? 'none' : 'block';
    });
});
