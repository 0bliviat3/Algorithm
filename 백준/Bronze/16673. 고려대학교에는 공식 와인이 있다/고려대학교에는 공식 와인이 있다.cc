#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int a, b, c;
	std::cin >> a >> b >> c;

	int sum = 0;
	while (a) {
		sum += (a * b + a * a * c);
		a--;
	}
	std::cout << sum;


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}