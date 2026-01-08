#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


void solve() {

	int n;
	std::cin >> n;

	int sum = n * -1;
	sum++;
	while (n--) {
		
		int k;
		std::cin >> k;
		sum += k;
	}

	std::cout << sum << "\n";

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}